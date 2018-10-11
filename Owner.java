package bicycleRentShop;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Owner {
    List<Customer> customerList= new ArrayList<>();
    List<Bicycle> bicycleList = new ArrayList<>();

    public  void addBicyclesToTheBicyclesList() {
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

    public void addCustomersToTheCustomerList() {
        String customerID = "customer1";
        List<Bicycle> rentedBicycleList = new ArrayList<>();
        List<RentedTime> rentedTimeList = new ArrayList<>();
        Map<Bicycle,RentedTime> map = new LinkedHashMap<>();
        Customer customer = new Customer(customerID,rentedBicycleList,rentedTimeList,map);
        customerList.add(customer);
        String customerID1 = "customer2";
        List<Bicycle> rentedBicycleList1 = new ArrayList<>();
        List<RentedTime> rentedTimeList1 = new ArrayList<>();
        Map<Bicycle,RentedTime> map1 = new LinkedHashMap<>();
        Customer customer1 = new Customer(customerID1,rentedBicycleList1,rentedTimeList1,map1);
        customerList.add(customer1);
        }

    public void rentABicycle(String customer1, String bicycle1, LocalDateTime startTime, LocalDateTime returnTime) {
        Customer customer = getCustomer(customer1);
        Bicycle bicycle = getBicycle(bicycle1);
        RentedTime  rentedTime = new RentedTime(startTime,returnTime);
        customer.rentABicycle(bicycle,customer,rentedTime);
        }

    private Bicycle getBicycle(String bicycle1) {
        for (Bicycle bicycle : bicycleList) {
            if(bicycle.bicycleID.equals(bicycle1)) {
                return bicycle;
            }
        }
        return null;
    }

    private Customer getCustomer(String customer1) {
        for (Customer customer:customerList) {
            if(customer.customerID.equals(customer1)) {
                return customer;
            }
        }
        return null;
    }

}




//LocalDateTime startTime = LocalDateTime.now();
//LocalDateTime returnTime = LocalDateTime.of(2018,10,18,7,15);
//RentedTime rentedTime = new RentedTime(startTime,returnTime);
//customer.rentABicycle();
