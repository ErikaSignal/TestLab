package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesTest {
    @Test
    public void testPayingEmployeesEveryoneGetsPayed(){
        EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);
        BankService bankService = Mockito.mock(BankService.class);
        Employees employees = new Employees(employeeRepository, bankService);

        Employee employee1 = new Employee("1", 20000);
        Employee employee2 = new Employee("2", 25000);
        Mockito.when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee1, employee2));

        int payment = employees.payEmployees();

        Mockito.verify(bankService, Mockito.times(2)).pay(Mockito.anyString(), Mockito.anyDouble());

        assertEquals(2, payment);
        assertTrue(employee1.isPaid());
        assertTrue(employee2.isPaid());
    }

    @Test
    public void testPayingEmployeesTrowsExceptionEmployeesNotPayed(){
        EmployeeRepository employeeRepository = new SpyEmployeeRepository();
        BankService bankService = new StubBankService();
        Employees employees = new Employees(employeeRepository, bankService);

        Employee employee1 = new Employee("1", 20000);
        Employee employee2 = new Employee("2", 25000);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        ((SpyEmployeeRepository) employeeRepository).setFindAllResult(Arrays.asList(employee1, employee2));

        ((StubBankService) bankService).setThrowException(true);

        RuntimeException exception = assertThrows(RuntimeException.class, employees::payEmployees);

        ((SpyEmployeeRepository) employeeRepository).verifySaveCalls(2);

        assertEquals("Payment failed", exception.getMessage());

        assertFalse(employee1.isPaid());
        assertFalse(employee2.isPaid());
    }

    //Moved test here to see coverage clearer
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