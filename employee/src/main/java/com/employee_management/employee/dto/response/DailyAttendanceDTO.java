package com.employee_management.employee.dto.response;

public class DailyAttendanceDTO {
    private String attendanceState;
    private String attendanceDate;
    private String attendanceTimeString;

    public String getAttendanceState() {
        return attendanceState;
    }

    public void setAttendanceState(String attendanceState) {
        this.attendanceState = attendanceState;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getAttendanceTimeString() {
        return attendanceTimeString;
    }

    public void setAttendanceTimeString(String attendanceTimeString) {
        this.attendanceTimeString = attendanceTimeString;
    }
}
