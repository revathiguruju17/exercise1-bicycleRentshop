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
    private OutputDriver outputDriver = new OutputDriver();

    Customer addCustomersToTheCustomerList(String customerID) {
        List<Bicycle> rentedBicycleList = new ArrayList<>();
        List<HiredInterval> rentedTimeList = new ArrayList<>();
        Customer customer = new Customer(customerID, rentedBicycleList, rentedTimeList);
        customerList.add(customer);
        return customer;
    }

    Bicycle getBicycle(String bicycle1) {
        for (Bicycle bicycle : bicycleList) {
            if (bicycle.bicycleID.equals(bicycle1)) {
                return bicycle;
            }
        }
        return  null;
    }

     Customer getCustomer(String customer1) {
        for (Customer customer : customerList) {
            if (customer.customerID.equals(customer1)) {
                return customer;
            }
        }
        return addCustomersToTheCustomerList(customer1);
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







