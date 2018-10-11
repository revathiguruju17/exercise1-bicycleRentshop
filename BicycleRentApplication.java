package bicycleRentShop;

import java.util.Scanner;

public class BicycleRentApplication {
    public static void main(String[] args) {
        Owner owner = new Owner();
        Customer customer = new Customer(null, null, null);
        owner.addBicyclesToTheBicyclesList();
        owner.addCustomersToTheCustomerList();
        printMenu();
        doAct(owner, customer);
    }

    private static void printMenu() {
        System.out.println("Press 1 to display the bicycles");
        System.out.println("Press 2 to hire a bicycle");
        System.out.println("Press 3 to return a bicycle");
        System.out.println("Press 4 to display the invoice of current hired bicycle");
        System.out.println("Press 5 to display the history of customer");
        System.out.println("Press 6 to display the history of owner");
        System.out.println("Press 7 to quit");
    }

    private static void doAct(Owner owner, Customer customer) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            option = scanner.nextInt();
            switch (option) {
                case 1: {
                    owner.displayTheListOfBicycles();
                    break;
                }
                case 2: {
                    System.out.println("enter customer ID and bicycle ID");
                    String customerID = scanner.next();
                    String bicycleID = scanner.next();
                    customer.rentBicycle(customerID, bicycleID, owner);
                    break;
                }
                case 3: {
                    System.out.println("enter customer ID and bicycle ID");
                    String customerID = scanner.next();
                    String bicycleID = scanner.next();
                    customer.returnBicycle(customerID, bicycleID, owner);
                    System.out.println("do you want to print invoice then press 4 or else type 7 to quit");
                    break;
                }
                case 4: {
                    
                }
                case 7: {
                    return;
                }
            }
        } while (option != 7);
    }
}
