package bicycleRentShop;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Owner {
    private List<Customer> customerList = new ArrayList<>();
    private List<Bicycle> bicycleList = new ArrayList<>();

    void addBicyclesToTheBicyclesList() {
        Bicycle bicycle1 = new Bicycle("bicycle1", 10);
        Bicycle bicycle2 = new Bicycle("bicycle2", 20);
        Bicycle bicycle3 = new Bicycle("bicycle3", 30);
        Bicycle bicycle4 = new Bicycle("bicycle4", 40);
        Bicycle bicycle5 = new Bicycle("bicycle5", 50);
        bicycleList.add(bicycle1);
        bicycleList.add(bicycle2);
        bicycleList.add(bicycle3);
        bicycleList.add(bicycle4);
        bicycleList.add(bicycle5);
    }

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

    public Bicycle getBicycle(String bicycle1) {
        for (Bicycle bicycle : bicycleList) {
            if (bicycle.bicycleID.equals(bicycle1)) {
                return bicycle;
            }
        }
        return null;
    }

    public Customer getCustomer(String customer1) {
        for (Customer customer : customerList) {
            if (customer.customerID.equals(customer1)) {
                return customer;
            }
        }
        return null;
    }

    public void displayTheListOfBicycles() {
        for (Bicycle bicycle : bicycleList) {
            bicycle.displayTheBicycle(bicycle);
        }
    }
}





