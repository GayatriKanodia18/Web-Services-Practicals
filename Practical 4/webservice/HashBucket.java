package webservice;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class HashBucket {

    @WebMethod
    public int calculation(int key, int bucket) {
        if (bucket <= 0) {
            return -1;
        }

        return key % bucket;
    }

    @WebMethod
    public String explainBucket(int key, int bucket) {
        if (bucket <= 0) {
            return "Invalid";
        }

        int buc = key % bucket;
        return "Student " + key + " will be in the " + buc + " buc";
    }
}
