package com.example;

public class StubBankService implements BankService{
    private boolean throwException = false;
    @Override
    public void pay(String id, double amount) {
        if (throwException) {
            throw new RuntimeException("Payment failed");
        }
        System.out.println("Payment executed successfully for ID: " + id);
    }

    public void setThrowException(boolean throwException) {
        this.throwException = throwException;
    }
}
