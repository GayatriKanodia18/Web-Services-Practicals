package com.example.webservice;

import jakarta.jws.*;

@WebService
public class TemperatureService {

    @WebMethod
    public double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    @WebMethod
    public double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
}
