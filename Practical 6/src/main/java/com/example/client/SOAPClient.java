package com.example.client;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.*; //HttpURLConnection

public class SOAPClient {

    public static String callService(int a, int b, String operation) throws Exception {

        String soap = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<soapenv:Envelope " +
                "xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                "xmlns:tns=\"http://webservice.example.com/\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<tns:" + operation + ">" +
                "<arg0>" + a + "</arg0>" +
                "<arg1>" + b + "</arg1>" +
                "</tns:" + operation + ">" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        URL url = new URL("http://localhost:8080/arithmetic");

        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty(
                "Content-Type",
                "text/xml;charset=UTF-8"
        );

        OutputStream os = connection.getOutputStream();

        os.write(soap.getBytes());
        os.flush();

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream()
                        )
                );

        String line;
        StringBuilder response = new StringBuilder();

        while ((line = br.readLine()) != null) {
            response.append(line);
        }

        br.close();

        return response.toString();
    }
}
