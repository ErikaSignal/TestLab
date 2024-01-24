package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    public void testEmployeeToString(){
        Employee employee = new Employee("1", 30000);
        assertEquals("Employee [id=1, salary=30000.0]", employee.toString());
    }
}