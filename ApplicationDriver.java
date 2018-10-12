package bicycleRentShop;

public class ApplicationDriver {

    private static final int DISPLAY_MENU = 1;
    private static final int DISPLAY_LIST_OF_BICYCLES = 2;
    private static final int BICYCLE_HIRING = 3;
    private static final int BICYCLE_RETURNING = 4;
    private static final int CUSTOMER_HISTORY = 5;
    private static final int OWNER_HISTORY = 6;
    private static final int QUIT = 7;

    void startApplication(Owner owner) {
        OutputDriver outputDriver = new OutputDriver();
        outputDriver.printMenu();
        doCustomerRequest(owner);
    }

    private void doCustomerRequest(Owner owner) {
        OutputDriver outputDriver = new OutputDriver();
        InputDriver inputDriver = new InputDriver();
        int option;
        do {
            option = inputDriver.scanUserInputAsInteger();
            switch (option) {
                case DISPLAY_MENU: {
                    outputDriver.printMenu();
                    break;
                }
                case DISPLAY_LIST_OF_BICYCLES: {
                    owner.displayTheListOfBicycles();
                    break;
                }
                case BICYCLE_HIRING: {
                    String ownerChoice = owner.permissionFromOwnerToHireABicycle();
                    if (ownerChoice.equals("yes")) {
                        hiringProcess(owner, inputDriver, outputDriver);
                    } else {
                        outputDriver.intimateUserAboutOwnerDecisionForHiringABicycle();
                    }
                    break;
                }
                case BICYCLE_RETURNING: {
                    returningProcess(owner, inputDriver, outputDriver);
                    break;
                }
                case CUSTOMER_HISTORY: {
                    outputDriver.enterCustomerName();
                    String customerID = inputDriver.scanUserInputAsString();
                    Customer customer = owner.getCustomer(customerID);
                    customer.getHiredBicycles(customerID, owner);
                    break;
                }
                case OWNER_HISTORY: {
                    owner.displayAllTheCustomersHistory(owner);
                    break;
                }
                case QUIT: {
                    return;
                }
            }
        } while (option < 7 && option > 0);
    }

    private void returningProcess(Owner owner, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.customerAndBicycleDetails();
        String customerID = inputDriver.scanUserInputAsString();
        String bicycleID = inputDriver.scanUserInputAsString();
        Customer customer = owner.getCustomer(customerID);
        customer.returnBicycle(customerID, bicycleID, owner);
        askCustomerForInvoice(customerID, bicycleID, owner, inputDriver, outputDriver);
    }

    private void askCustomerForInvoice(String customerID, String bicycleID, Owner owner,
                                       InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.askUserAboutInvoice();
        String userChoice = inputDriver.scanUserInputAsString();
        if (userChoice.equals("yes")) {
            owner.generateInvoice(customerID, bicycleID);
        }
    }

    private void hiringProcess(Owner owner, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.customerAndBicycleDetails();
        String customerID = inputDriver.scanUserInputAsString();
        String bicycleID = inputDriver.scanUserInputAsString();
        Customer customer = owner.getCustomer(customerID);
        customer.rentBicycle(customerID, bicycleID, owner);
    }
}
