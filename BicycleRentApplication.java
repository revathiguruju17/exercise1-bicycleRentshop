package bicycleRentShop;

public class BicycleRentApplication {
    public static void main(String[] args) {
        Owner owner = new Owner();
        OutputDriver outputDriver = new OutputDriver();
        owner.addBicyclesToTheBicyclesList();
        outputDriver.printMenu();
        doCustomerRequest(owner);
    }

    private static void doCustomerRequest(Owner owner) {
        OutputDriver outputDriver = new OutputDriver();
        InputDriver inputDriver = new InputDriver();
        int option;
        do {
            option = inputDriver.scanUserInputAsInteger();
            switch (option) {
                case 1: {
                    outputDriver.printMenu();
                    break;
                }
                case 2: {
                    owner.displayTheListOfBicycles();
                    break;
                }
                case 3: {
                    outputDriver.customerAndBicycleDetails();
                    String ownerChoice = owner.permissionFromOwnerToHireABicycle();
                    if (ownerChoice.equals("yes")) {
                        String customerID = inputDriver.scanUserInputAsString();
                        String bicycleID = inputDriver.scanUserInputAsString();
                        Customer customer = owner.getCustomer(customerID);
                        customer.rentBicycle(customerID, bicycleID, owner);
                    }
                    else {
                        outputDriver.intimateUserAboutOwnerDecisionForHiringABicycle();
                    }
                    break;
                }
                case 4: {
                    outputDriver.customerAndBicycleDetails();
                    String customerID = inputDriver.scanUserInputAsString();
                    String bicycleID = inputDriver.scanUserInputAsString();
                    Customer customer =owner.getCustomer(customerID);
                    customer.returnBicycle(customerID, bicycleID, owner);
                    outputDriver.askUserAboutInvoice();
                    String userChoice = inputDriver.scanUserInputAsString();
                    if(userChoice.equals("yes")) {
                        owner.generateInvoice(customerID,bicycleID);
                    }
                    break;
                }
                case 5: {
                    outputDriver.enterCustomerName();
                    String customerID = inputDriver.scanUserInputAsString();
                    Customer customer = owner.getCustomer(customerID);
                    customer.getHiredBicycles(customerID,owner);
                    break;
                }
                case 6: {
                    owner.displayAllTheCustomersHistory(owner);
                    break;
                }
                case 7: {
                    return;
                }
            }
        } while (option<6 && option>0);
    }
}
