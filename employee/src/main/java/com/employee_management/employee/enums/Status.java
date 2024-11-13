package com.employee_management.employee.enums;

public enum Status {

    ACTIVE("Y"), INACTIVE("N");

    private final String value;

    Status(String value) {
        this.value = value;
    }
}
