package bicycleRentShop;

import java.time.LocalDateTime;
import java.util.List;

class Customer {
    final String customerID;
    List<Bicycle> hiredBicycles;
    List<HiredInterval> hiredIntervalList;

    Customer(String customerID, List<Bicycle> hiredBicycles, List<HiredInterval> hiredIntervalList) {
        this.customerID = customerID;
        this.hiredBicycles = hiredBicycles;
        this.hiredIntervalList = hiredIntervalList;
    }

    private OutputDriver outputDriver = new OutputDriver();


    void returnBicycle(String customerID, String bicycleID, Owner owner) {
        Customer customer = owner.getCustomer(customerID);
        Bicycle bicycle1 = owner.getBicycle(bicycleID);
        int i=-1;
        for (Bicycle bicycle : customer.hiredBicycles) {
            i++;
            if (bicycle.equals(bicycle1)) {
                bicycle.setStatusOfBicycle(bicycle);
                customer.hiredIntervalList.get(i).returnedTime=LocalDateTime.now();
                break;
            }
        }

    }

    void getHiredBicycles(String customerID, Owner owner) {
        Customer customer = owner.getCustomer(customerID);
        for (int i = 0; i < customer.hiredBicycles.size(); i++) {
            owner.generateInvoice(customer.customerID, customer.hiredBicycles.get(i).bicycleID);
        }
    }

    void rentBicycle(String customerID, String bicycleID, Owner owner) {
        Customer customer = owner.getCustomer(customerID);
        Bicycle bicycle = owner.getBicycle(bicycleID);
        boolean statusOfBicycle = bicycle.getStatusOfBicycle(bicycle);
        if (statusOfBicycle) {
            customer.hiredBicycles.add(bicycle);
            customer.hiredIntervalList.add(new HiredInterval(LocalDateTime.now(),LocalDateTime.now()));
            bicycle.setStatusOfBicycle(bicycle);
        } else {
            outputDriver.displayTheBicycleStatusAsUnavailable();
        }
    }
}

