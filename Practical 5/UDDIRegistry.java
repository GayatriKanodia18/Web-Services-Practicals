import java.util.ArrayList;

public class UDDIRegistry {

    private ArrayList<ServiceInfo> services = new ArrayList<>();

    // Register a new service
    public void registerService(ServiceInfo service) {
        services.add(service);
        System.out.println("\nService Registered Successfully!");
    }

    // Search service by name
    public ServiceInfo findService(String serviceName) {
        for (ServiceInfo service : services) {
            if (service.getServiceName().equalsIgnoreCase(serviceName)) {
                return service;
            }
        }

        return null;
    }

    // Display all registered services
    public void displayServices() {
        if (services.isEmpty()) {
            System.out.println("No Services Registered.");
            return;
        }

        System.out.println("\n===== Registered Services =====");

        for (ServiceInfo service : services) {
            System.out.println("-------------------------------");
            System.out.println(service);
        }
    }
}
