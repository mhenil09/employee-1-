package com.employee_management.employee.service;

import com.employee_management.employee.dto.request.AttendanceRequest;
import com.employee_management.employee.dto.response.AttendanceReportDTO;
import com.employee_management.employee.dto.response.DailyAttendanceDTO;
import com.employee_management.employee.entity.Employee;
import com.employee_management.employee.entity.EmployeeAttendance;
import com.employee_management.employee.enums.AttendanceState;
import com.employee_management.employee.enums.Status;
import com.employee_management.employee.exception.CustomException;
import com.employee_management.employee.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeAttendanceService {

    @Autowired private EmployeeService employeeService;
    @Autowired private AttendanceRepository attendanceRepository;

    public ResponseEntity<String> postAttendance(@RequestBody AttendanceRequest attendanceRequest) {
        Employee employee = employeeService.findByEmployeeCode(attendanceRequest.getEmployeeCode());
        EmployeeAttendance employeeAttendance = new EmployeeAttendance();
        employeeAttendance.setAttendanceDate(LocalDate.now());
        employeeAttendance.setInTime(attendanceRequest.getStartTime());
        employeeAttendance.setOutTime(attendanceRequest.getEndTime());
        employeeAttendance.setAttendanceStatus(attendanceRequest.getAttendanceState());
        employeeAttendance.setEmployee(employee);
        attendanceRepository.save(employeeAttendance);
        return new ResponseEntity<>("Attendance added successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<List<AttendanceReportDTO>> fetchAllAttendance(Month month) {
        Map<Employee, List<EmployeeAttendance>> employeeWiseAttendance = attendanceRepository.findAll().stream().filter(x -> Status.ACTIVE.equals(x.getEmployee().getIsActive()) && x.getAttendanceDate().getMonth().equals(month) && x.getAttendanceDate().getYear() == LocalDate.now().getYear()).collect(Collectors.groupingBy(EmployeeAttendance::getEmployee));
        if(employeeWiseAttendance.isEmpty()) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
        }
        List<AttendanceReportDTO> attendanceReportDTOS = new ArrayList<>();
        employeeWiseAttendance.forEach((employee, attendanceList) -> {
            if(!attendanceList.isEmpty()) {
                int presentCount=0, absentCount=0, leaveCount=0, wfhCount=0;
                AttendanceReportDTO attendanceReportDTO = new AttendanceReportDTO();
                attendanceReportDTO.setEmployeeCode(employee.getEmployeeCode());
                attendanceReportDTO.setEmployeeName(employee.getEmployeeName());
                attendanceReportDTO.setDesignationName(employee.getDesignation().getDesignationName());
                List<DailyAttendanceDTO> dailyAttendanceDTOS = new ArrayList<>();
                for(EmployeeAttendance attendance : attendanceList) {
                    DailyAttendanceDTO dailyAttendanceDTO = new DailyAttendanceDTO();
                    dailyAttendanceDTO.setAttendanceDate(attendance.getAttendanceDate().toString());
                    dailyAttendanceDTO.setAttendanceTimeString(getInOutTimeString(attendance));
                    dailyAttendanceDTO.setAttendanceState(attendance.getAttendanceStatus().toString());
                    if(AttendanceState.ABSENT.equals(attendance.getAttendanceStatus()))
                        absentCount+=1;
                    if(AttendanceState.PRESENT.equals(attendance.getAttendanceStatus()))
                        presentCount+=1;
                    if(AttendanceState.LEAVE.equals(attendance.getAttendanceStatus()))
                        leaveCount+=1;
                    if(AttendanceState.WORK_FROM_HOME.equals(attendance.getAttendanceStatus()))
                        wfhCount+=1;
                    dailyAttendanceDTOS.add(dailyAttendanceDTO);
                }
                attendanceReportDTO.setAbsentCount(absentCount);
                attendanceReportDTO.setPresentCount(presentCount);
                attendanceReportDTO.setLeaveCount(leaveCount);
                attendanceReportDTO.setWfhCount(wfhCount);
                attendanceReportDTO.setDailyAttendanceList(dailyAttendanceDTOS);
                attendanceReportDTOS.add(attendanceReportDTO);
            }
        });
        return new ResponseEntity<>(attendanceReportDTOS, HttpStatus.OK);
    }

    private String getInOutTimeString(EmployeeAttendance attendance) {
        return attendance.getInTime().toString() + " - " + attendance.getOutTime().toString();
    }
}
