package com.kafka.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.poc.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
