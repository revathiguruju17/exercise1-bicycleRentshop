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

    void generateInvoice(String customerID, String bicycleID, Owner owner) {
        Customer customer = owner.getCustomer(customerID);
        Bicycle bicycle = owner.getBicycle(bicycleID);
        for (int i = 0; i < customer.hiredBicycles.size(); i++) {
            if (customer.hiredBicycles.get(i).equals(bicycle)) {
                double rentCost = bicycle.calculateRent(bicycle, customer.hiredIntervalList.get(i));
                outputDriver.printInvoice(bicycle.bicycleID, bicycle.rentPerHour, customer.hiredIntervalList.get(i).hiredTime,
                        customer.hiredIntervalList.get(i).returnedTime, rentCost);
                break;
            }
        }
    }

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
            generateInvoice(customer.customerID, customer.hiredBicycles.get(i).bicycleID, owner);
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
            outputDriver.displayTheBicycleStatusAsInavailable();
        }
    }
}

