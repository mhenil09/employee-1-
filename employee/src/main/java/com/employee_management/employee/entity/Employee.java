package com.employee_management.employee.entity;

import com.employee_management.employee.enums.Status;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee_master")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "employee_code", nullable = false, unique = true)
    private String employeeCode;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @ManyToOne
    @JoinColumn(name = "designation_id", nullable = false)
    private Designation designation;

    @Column(name = "is_active", nullable = false)
    private Status isActive;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeAttendance> attendanceRecords;

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

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Status getIsActive() {
        return isActive;
    }

    public void setIsActive(Status isActive) {
        this.isActive = isActive;
    }

    public List<EmployeeAttendance> getAttendanceRecords() {
        return attendanceRecords;
    }

    public void setAttendanceRecords(List<EmployeeAttendance> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }
}