package com.employee_management.employee.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "designation_master")
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "designation_id")
    private Long designationId;

    @Column(name = "designation_code", nullable = false, unique = true)
    private String designationCode;

    @Column(name = "designation_name", nullable = false)
    private String designationName;

    @OneToMany(mappedBy = "designation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;

    public String getDesignationCode() {
        return designationCode;
    }

    public void setDesignationCode(String designationCode) {
        this.designationCode = designationCode;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}