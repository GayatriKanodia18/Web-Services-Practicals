package com.example.webservice;

import jakarta.jws.*;

@WebService
public class ArithmeticService {

    @WebMethod
    public int add(int a, int b) {
        return a + b;
    }

    @WebMethod
    public int subtract(int a, int b) {
        return a - b;
    }

    @WebMethod
    public int multiply(int a, int b) {
        return a * b;
    }

    @WebMethod
    public double divide(int a, int b) {
        return (double)a / b;
    }
}
