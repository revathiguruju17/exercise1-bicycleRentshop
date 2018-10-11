package bicycleRentShop;

public class BicycleRentApplication {
    public static void main(String[] args) {
        Owner owner = new Owner();
        OutputDriver outputDriver = new OutputDriver();
        Customer customer = new Customer(null, null, null);
        owner.addBicyclesToTheBicyclesList();
        owner.addCustomersToTheCustomerList();
        outputDriver.printMenu();
        doAct(owner, customer);
    }

    private static void doAct(Owner owner, Customer customer) {
        OutputDriver outputDriver = new OutputDriver();
        InputDriver inputDriver = new InputDriver();
        int option;
        do {
            option = inputDriver.scanUserInputAsInteger();
            switch (option) {
                case 1: {
                    owner.displayTheListOfBicycles();
                    break;
                }
                case 2: {
                    outputDriver.customerAndBicycleDetails();
                    String customerID = inputDriver.scanUserInputAsString();
                    String bicycleID = inputDriver.scanUserInputAsString();
                    customer.rentBicycle(customerID, bicycleID, owner);
                    break;
                }
                case 3: {
                    outputDriver.customerAndBicycleDetails();
                    String customerID = inputDriver.scanUserInputAsString();
                    String bicycleID = inputDriver.scanUserInputAsString();
                    customer.returnBicycle(customerID, bicycleID, owner);
                    outputDriver.askUserAboutInvoice();
                    String userChoice = inputDriver.scanUserInputAsString();
                    if(userChoice.equals("yes"))
                    {
                        customer.generateInvoice(customerID,bicycleID,owner);
                    }
                    break;
                }
                case 4: {
                    outputDriver.enterCustomerName();
                    String customerID = inputDriver.scanUserInputAsString();
                    customer.getHiredBicycles(customerID,owner);
                    break;
                }
                case 5: {
                    owner.displayAllTheCustomersHistory(owner);
                    break;
                }
                case 6: {
                    return;
                }
            }
        } while (option != 6);
    }
}
