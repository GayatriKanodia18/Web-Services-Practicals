import java.util.*;

class name_city {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your city :");
        String city = sc.nextLine();
        System.out.println("Hello, " + name + " you live in :" + city);
    }
}
