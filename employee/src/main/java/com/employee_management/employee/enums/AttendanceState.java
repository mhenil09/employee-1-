package com.employee_management.employee.enums;

public enum AttendanceState {

    PRESENT("P"), ABSENT("A"), HALF_DAY("H"), LEAVE("L"), WORK_FROM_HOME("WH");

    private final String state;

    private AttendanceState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
