package bicycleRentShop;

public class BicycleRentApplication {
    public static void main(String[] args) {
        Owner owner = new Owner();
        OutputDriver outputDriver = new OutputDriver();
        owner.addBicyclesToTheBicyclesList();
        outputDriver.printMenu();
        doAct(owner);
    }

    private static void doAct(Owner owner) {
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
                    Customer customer = owner.getCustomer(customerID);
                    customer.rentBicycle(customerID, bicycleID, owner);
                    break;
                }
                case 3: {
                    outputDriver.customerAndBicycleDetails();
                    String customerID = inputDriver.scanUserInputAsString();
                    String bicycleID = inputDriver.scanUserInputAsString();
                    Customer customer =owner.getCustomer(customerID);
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
                    Customer customer = owner.getCustomer(customerID);
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
        } while (option<6 && option>0);
    }
}
