package bicycleRentShop;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    private List<Customer> customerList = new ArrayList<>();
    private List<Bicycle> bicycleList = new ArrayList<>();
    void addBicyclesToTheBicyclesList() {
        Bicycle bicycle1 = new Bicycle("bicycle1", 3600);
        Bicycle bicycle2 = new Bicycle("bicycle2", 7200);
        Bicycle bicycle3 = new Bicycle("bicycle3", 36000);
        Bicycle bicycle4 = new Bicycle("bicycle4", 72000);
        bicycleList.add(bicycle1);
        bicycleList.add(bicycle2);
        bicycleList.add(bicycle3);
        bicycleList.add(bicycle4);
    }
    OutputDriver outputDriver = new OutputDriver();

    void addCustomersToTheCustomerList() {
        String customerID = "customer1";
        List<Bicycle> rentedBicycleList = new ArrayList<>();
        List<HiredInterval> rentedTimeList = new ArrayList<>();
        Customer customer = new Customer(customerID, rentedBicycleList, rentedTimeList);
        customerList.add(customer);
        String customerID1 = "customer2";
        List<Bicycle> rentedBicycleList1 = new ArrayList<>();
        List<HiredInterval> rentedTimeList1 = new ArrayList<>();
        Customer customer1 = new Customer(customerID1, rentedBicycleList1, rentedTimeList1);
        customerList.add(customer1);
    }

    Bicycle getBicycle(String bicycle1) {
        for (Bicycle bicycle : bicycleList) {
            if (bicycle.bicycleID.equals(bicycle1)) {
                return bicycle;
            }
        }
        return null;
    }

     Customer getCustomer(String customer1) {
        for (Customer customer : customerList) {
            if (customer.customerID.equals(customer1)) {
                return customer;
            }
        }
        return null;
    }

    void displayTheListOfBicycles() {
        for (Bicycle bicycle : bicycleList) {
            bicycle.displayTheBicycle(bicycle);
        }
    }

    void displayAllTheCustomersHistory(Owner owner) {
        for (Customer customer : customerList) {
            outputDriver.printTheCustomerID(customer.customerID);
            customer.getHiredBicycles(customer.customerID, owner);
        }
    }
}







