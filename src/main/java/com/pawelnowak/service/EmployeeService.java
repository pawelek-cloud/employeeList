package com.pawelnowak.service;

import com.pawelnowak.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById (int theId);

    void save (Employee theEmplyee);

    void deleteById (int theId);
}
