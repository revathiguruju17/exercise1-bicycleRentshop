package bicycleRentShop;

import java.time.LocalDateTime;
import java.util.List;

class Customer {
    final String customerID;
    private List<Bicycle> hiredBicycles;
    private List<HiredInterval> hiredIntervals;

    Customer(String customerID, List<Bicycle> hiredBicycles, List<HiredInterval> hiredIntervals) {
        this.customerID = customerID;
        this.hiredBicycles = hiredBicycles;
        this.hiredIntervals = hiredIntervals;
    }

    private OutputDriver outputDriver = new OutputDriver();

    void returnBicycle(String customerID, String bicycleID, Owner owner) {
        Customer customer = owner.getCustomer(customerID);
        Bicycle bicycle1 = owner.getBicycle(bicycleID);
        int index = -1;
        for (Bicycle bicycle : customer.hiredBicycles) {
            index++;
            boolean compareToObjects = bicycle.compareTobicycleObjects(bicycle1, bicycle);
            if (compareToObjects) {
                updateCustomerDetailsAfterReturningTheBicycle(bicycle, customer, index);
                return;
            }
        }
        outputDriver.invalidBicycleToReturn();
    }

    private void updateCustomerDetailsAfterReturningTheBicycle(Bicycle bicycle, Customer customer, int index) {
        bicycle.setStatusOfBicycle(bicycle);
        customer.hiredIntervals.get(index).returnedTime = LocalDateTime.now();
        customer.hiredIntervals.get(index).rentedCost = bicycle.calculateRent(bicycle, hiredIntervals.get(index));
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
            updateCustomerDetailsAfterHiringABicycle(bicycle, customer);
            return;
        }
        outputDriver.displayTheBicycleStatusAsUnavailable();
    }

    private void updateCustomerDetailsAfterHiringABicycle(Bicycle bicycle, Customer customer) {
        customer.hiredBicycles.add(bicycle);
        customer.hiredIntervals.add(new HiredInterval(LocalDateTime.now(), LocalDateTime.now(), 0.0));
        bicycle.setStatusOfBicycle(bicycle);
    }

    String getDetailsOfCustomer(Customer customer, Bicycle bicycle) {
        for (int i = 0; i < customer.hiredBicycles.size(); i++) {
            Bicycle bicycle1 = customer.hiredBicycles.get(i);
            if (bicycle.compareTobicycleObjects(bicycle1, bicycle)) {
                HiredInterval hiredInterval = customer.hiredIntervals.get(i);
                String bicycleDetails = bicycle1.displayTheHiredBicycleForInvoice(bicycle1);
                String hiredDetails = hiredInterval.returnAsStringHiredInterval(hiredInterval);
                return bicycleDetails+hiredDetails;
            }
        }
        return null;
    }
}

