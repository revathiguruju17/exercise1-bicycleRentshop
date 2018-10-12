package bicycleRentShop;

public class ApplicationDriver {
    void startApplication(Owner owner) {
        OutputDriver outputDriver = new OutputDriver();
        outputDriver.printMenu();
        doCustomerRequest(owner);
    }

    private  void doCustomerRequest(Owner owner) {
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
                    String ownerChoice = owner.permissionFromOwnerToHireABicycle();
                    if (ownerChoice.equals("yes")) {
                        hiringProcess(owner,inputDriver,outputDriver);
                    } else {
                        outputDriver.intimateUserAboutOwnerDecisionForHiringABicycle();
                    }
                    break;
                }
                case 4: {
                    returningProcess(owner,inputDriver,outputDriver);
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
        } while (option<7 && option>0);
    }

    private void returningProcess(Owner owner, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.customerAndBicycleDetails();
        String customerID = inputDriver.scanUserInputAsString();
        String bicycleID = inputDriver.scanUserInputAsString();
        Customer customer =owner.getCustomer(customerID);
        customer.returnBicycle(customerID, bicycleID, owner);
        askCustomerForInvoice(customerID,bicycleID,owner,inputDriver,outputDriver);
    }

    private void askCustomerForInvoice(String customerID, String bicycleID, Owner owner,InputDriver inputDriver,OutputDriver outputDriver) {
        outputDriver.askUserAboutInvoice();
        String userChoice = inputDriver.scanUserInputAsString();
        if(userChoice.equals("yes")) {
            owner.generateInvoice(customerID,bicycleID);
        }
    }

    private void hiringProcess(Owner owner,InputDriver inputDriver,OutputDriver outputDriver) {
        outputDriver.customerAndBicycleDetails();
        String customerID = inputDriver.scanUserInputAsString();
        String bicycleID = inputDriver.scanUserInputAsString();
        Customer customer = owner.getCustomer(customerID);
        customer.rentBicycle(customerID, bicycleID, owner);
    }
}
