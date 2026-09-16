import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UDDIRegistry registry = new UDDIRegistry();

        int choice;

        do {

            System.out.println("\n====== Simple UDDI Registry ======");
            System.out.println("1. Register Service");
            System.out.println("2. Search Service");
            System.out.println("3. Display All Services");
            System.out.println("4. Exit");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Business Name : ");
                    String business = sc.nextLine();

                    System.out.print("Service Name : ");
                    String service = sc.nextLine();

                    System.out.print("Service URL : ");
                    String url = sc.nextLine();

                    registry.registerService(
                        new ServiceInfo(service, business, url)
                    );

                    break;

                case 2:

                    System.out.print("Enter Service Name : ");
                    String search = sc.nextLine();

                    ServiceInfo result = registry.findService(search);

                    if (result != null) {
                        System.out.println("\nService Found");
                        System.out.println(result);
                    } else {
                        System.out.println("Service Not Found");
                    }

                    break;

                case 3:

                    registry.displayServices();

                    break;

                case 4:

                    System.out.println("Thank You");

                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
