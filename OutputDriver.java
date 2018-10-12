package bicycleRentShop;

class OutputDriver {
    void printMenu() {
        System.out.println("Press 1 to see the menu");
        System.out.println("Press 2 to see the bicycles");
        System.out.println("Press 3 to hire a bicycle");
        System.out.println("Press 4 to return a bicycle");
        System.out.println("Press 5 to see the history of customer");
        System.out.println("Press 6 to see the history of owner");
        System.out.println("Press 7 to quit");
    }

    void customerAndBicycleDetails() {
        System.out.println("enter customer ID and bicycle ID");
    }

    void askUserAboutInvoice() {
        System.out.println("do you want to print invoice type yes or press 6 to exit");
    }

    void printBicycleDetails(String bicycleID, int rentPerHour, Boolean isAvailable) {
        System.out.print(bicycleID + "  " + rentPerHour + "rs/hour  ");
        if (isAvailable) {
            System.out.println("available");
        } else {
            System.out.println("Not available");
        }
    }

    void displayTheBicycleStatusAsUnavailable() {
        System.out.println("The bicycle is currently not available");
    }

    void enterCustomerName() {
        System.out.println("enter customerID");
    }

    void printTheCustomerID(String customerID) {
        System.out.println(customerID);
    }

    void intimateUserAboutOwnerDecisionForHiringABicycle() {
        System.out.println("Sorry you can't hire a bicycle");
    }

    void invalidBicycleToReturn() {
        System.out.println("You are trying to return the bicycle is not hired by you. Please check the bicycle name");
    }

    void displayTheInvoice(String invoiceDetails) {
        System.out.println(invoiceDetails);
    }
}
