package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpyEmployeeRepository implements EmployeeRepository{

    private List<Employee> savedEmployees = new ArrayList<>();
    @Override
    public List<Employee> findAll() {
        return Arrays.asList(new Employee("1", 1000), new Employee("2", 1500));
    }

    @Override
    public Employee save(Employee e) {
        savedEmployees.add(e);
        return e;
    }

    public List<Employee> getSavedEmployees() {
        return savedEmployees;
    }
}
