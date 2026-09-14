package com.example.webservice;

import jakarta.xml.ws.Endpoint;

public class Publisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/arithmetic", new ArithmeticService());
        System.out.println("Arithmetic Web Service Running...");
    }
}
