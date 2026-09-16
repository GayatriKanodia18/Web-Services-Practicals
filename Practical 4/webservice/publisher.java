package webservice;

import jakarta.xml.ws.Endpoint;

public class publisher {

    public static void main(String[] args) {

        Endpoint.publish(
            "http://localhost:8080/ws/HashBucket",
            new HashBucket()
        );

        System.out.println("HashBucket Web Service Running...");
    }
}
