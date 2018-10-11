package bicycleRentShop;

import java.util.List;
import java.util.Map;

public class Customer {
    final String customerID;
    private List<Bicycle> hiredBicycles;
    private List<RentedTime> rentedTimeList;
    private Map<Bicycle,RentedTime> map;

    public Customer(String customerID, List<Bicycle> hiredBicycles, List<RentedTime> rentedTimeList, Map<Bicycle, RentedTime> map) {
        this.customerID = customerID;
        this.hiredBicycles = hiredBicycles;
        this.rentedTimeList = rentedTimeList;
        this.map = map;
    }

    void rentBicycle(Bicycle bicycle, Customer customer,RentedTime rentedTime) {
        boolean statusOfBicycle =bicycle.getStatusOfBicycle(bicycle);
        if(statusOfBicycle){
            customer.hiredBicycles.add(bicycle);
            customer.rentedTimeList.add(rentedTime);
            System.out.println(customerID+" Invoice");
            generateInvoice(bicycle,rentedTime);
            bicycle.setStatusOfBicycle(bicycle);
        }
    }

    private void generateInvoice(Bicycle bicycle, RentedTime rentedTime) {
        double rentCost = bicycle.calculateRent(bicycle,rentedTime);
        System.out.println(bicycle.bicycleID+"  "+bicycle.rentPerHour+"  "+rentedTime.startTime+"  "+rentedTime.endTime+"  "+rentCost);
        System.out.println();
    }

    void getHiredBicycles(Customer customer) {
        for (Bicycle bicycle : customer.hiredBicycles) {
            bicycle.displayTheBicycle(bicycle);
        }
    }

    void returnABicycle(Customer customer,String bicycleID) {
        for (Bicycle bicycle:customer.hiredBicycles) {
           if(bicycleID.equals(bicycle.bicycleID)){
               bicycle.setStatusOfBicycle(bicycle);
           }
        }
    }
}
