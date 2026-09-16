public class ServiceInfo {

    private String serviceName;
    private String businessName;
    private String serviceURL;

    public ServiceInfo(String serviceName, String businessName, String serviceURL) {
        this.serviceName = serviceName;
        this.businessName = businessName;
        this.serviceURL = serviceURL;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getServiceURL() {
        return serviceURL;
    }

    @Override
    public String toString() {
        return "Business Name : " + businessName +
               "\nService Name : " + serviceName +
               "\nService URL : " + serviceURL;
    }
}
