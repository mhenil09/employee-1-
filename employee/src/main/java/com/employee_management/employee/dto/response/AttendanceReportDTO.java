package com.employee_management.employee.dto.response;

import java.util.List;

public class AttendanceReportDTO {

    private String employeeCode;
    private String employeeName;
    private String designationName;
    private List<DailyAttendanceDTO> dailyAttendanceList;
    private Integer presentCount;
    private Integer absentCount;
    private Integer wfhCount;
    private Integer leaveCount;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public List<DailyAttendanceDTO> getDailyAttendanceList() {
        return dailyAttendanceList;
    }

    public void setDailyAttendanceList(List<DailyAttendanceDTO> dailyAttendanceList) {
        this.dailyAttendanceList = dailyAttendanceList;
    }

    public Integer getPresentCount() {
        return presentCount;
    }

    public void setPresentCount(Integer presentCount) {
        this.presentCount = presentCount;
    }

    public Integer getAbsentCount() {
        return absentCount;
    }

    public void setAbsentCount(Integer absentCount) {
        this.absentCount = absentCount;
    }

    public Integer getWfhCount() {
        return wfhCount;
    }

    public void setWfhCount(Integer wfhCount) {
        this.wfhCount = wfhCount;
    }

    public Integer getLeaveCount() {
        return leaveCount;
    }

    public void setLeaveCount(Integer leaveCount) {
        this.leaveCount = leaveCount;
    }
}
