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
        BankService stubBankService = new StubBankService();
        Employees employees = new Employees(employeeRepository, stubBankService);

        ((StubBankService) stubBankService).setThrowException(true);

        Employee employee1 = new Employee("1", 20000);
        Employee employee2 = new Employee("2", 25000);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        int payment = employees.payEmployees();

        assertEquals(0, payment);
        assertFalse(employee1.isPaid());
        assertFalse(employee2.isPaid());
    }
}