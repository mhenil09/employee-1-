package com.employee_management.employee.dto.request;

import com.employee_management.employee.enums.AttendanceState;
import java.time.LocalTime;

public class AttendanceRequest {

    private String employeeCode;
    private LocalTime startTime;
    private LocalTime endTime;
    private AttendanceState attendanceState;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public AttendanceState getAttendanceState() {
        return attendanceState;
    }

    public void setAttendanceState(AttendanceState attendanceState) {
        this.attendanceState = attendanceState;
    }
}
