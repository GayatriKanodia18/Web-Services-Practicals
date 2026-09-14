package com.example.webservice;

import jakarta.xml.ws.Endpoint;

public class Publisher {
    public static void main(String[] args) {
        Endpoint.publish(
            "http://localhost:8080/temperature",
            new TemperatureService()
        );

        System.out.println("Temperature Web Service Running...");
    }
}
