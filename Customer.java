package bicycleRentShop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    final String customerID;
    List<Bicycle> hiredBicycles;
    List<RentedTime> rentedTimeList;
    Map<Bicycle,RentedTime> map;

    public Customer(String customerID, List<Bicycle> hiredBicycles, List<RentedTime> rentedTimeList, Map<Bicycle, RentedTime> map) {
        this.customerID = customerID;
        this.hiredBicycles = hiredBicycles;
        this.rentedTimeList = rentedTimeList;
        this.map = map;
    }

    void rentABicycle(Bicycle bicycle, Customer customer,RentedTime rentedTime) {
        boolean statusOfBicycle =bicycle.getStatusOfBicycle(bicycle);
        if(statusOfBicycle){
            customer.hiredBicycles.add(bicycle);
            customer.rentedTimeList.add(rentedTime);
            bicycle.setStatusOfBicycle(bicycle);
        }
    }

    void getHiredBicycles() {
        for (Bicycle bicycle : hiredBicycles) {
            bicycle.displayTheBicycle(bicycle);
        }
    }

    void returnABicycle(Bicycle bicycle, Customer customer) {
        boolean statusOfBicycle =bicycle.getStatusOfBicycle(bicycle);
        if(!statusOfBicycle){
            bicycle.setStatusOfBicycle(bicycle);
        }
    }
}
