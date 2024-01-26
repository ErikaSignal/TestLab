package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    public void testEmployeeToString(){
        Employee employee = new Employee("1", 30000);
        assertEquals("Employee [id=1, salary=30000.0]", employee.toString());
    }

    @Test
    public void testSetID(){
        Employee employee = new Employee("1", 17000);

        employee.setId("1");

        assertEquals("1", employee.getId());
    }

    @Test
    public void testSetSalary(){
        Employee employee = new Employee("1", 23500);

        employee.setSalary(25000);

        assertEquals(25000, employee.getSalary());
    }
}