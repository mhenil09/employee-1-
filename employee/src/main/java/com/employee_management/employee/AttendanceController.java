package com.employee_management.employee;

import com.employee_management.employee.dto.request.AttendanceRequest;
import com.employee_management.employee.dto.response.AttendanceReportDTO;
import com.employee_management.employee.service.EmployeeAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

    @Autowired private EmployeeAttendanceService employeeAttendanceService;

    @PostMapping
    public ResponseEntity<String> postAttendance(@RequestBody AttendanceRequest attendanceRequest) {
        return employeeAttendanceService.postAttendance(attendanceRequest);
    }

    @GetMapping(value = "/get-monthwise-attendance/{month}")
    public ResponseEntity<List<AttendanceReportDTO>> getMonthwiseAttendance(@PathVariable("month") Month month) {
        return employeeAttendanceService.fetchAllAttendance(month);
    }
}
