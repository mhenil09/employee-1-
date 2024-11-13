package com.employee_management.employee.repository;

import com.employee_management.employee.entity.EmployeeAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<EmployeeAttendance, Long> {

}
