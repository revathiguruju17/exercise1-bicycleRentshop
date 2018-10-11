package bicycleRentShop;

import java.util.List;

public class Customer {
    final String customerID;
    private List<Bicycle> hiredBicycles;
    private List<HiredInterval> hiredIntervalList;

    public Customer(String customerID, List<Bicycle> hiredBicycles, List<HiredInterval> hiredIntervalList) {
        this.customerID = customerID;
        this.hiredBicycles = hiredBicycles;
        this.hiredIntervalList = hiredIntervalList;
    }

    private void generateInvoice(Bicycle bicycle, Customer customer) {
        for (int i = 0; i < customer.hiredBicycles.size(); i++) {
            if (customer.hiredBicycles.get(i).equals(bicycle)) {
                double rentCost = bicycle.calculateRent(bicycle, customer.hiredIntervalList.get(i));
                System.out.println(bicycle.bicycleID + "  " + bicycle.rentPerHour + "  " + customer.hiredIntervalList.get(i).hiredTime
                        + "  " + customer.hiredIntervalList.get(i).returnedTime + "  " + rentCost);
                break;
            }
        }
    }

    void returnBicycle(String customerID, String bicycleID,Owner owner) {
        Customer customer = owner.getCustomer(customerID);
        Bicycle bicycle1 = owner.getBicycle(bicycleID);
        for (Bicycle bicycle : customer.hiredBicycles) {
            if (bicycle.equals(bicycle1)) {
                bicycle.setStatusOfBicycle(bicycle);
                generateInvoice(bicycle1, customer);
                break;
            }
        }

    }

    public void getHiredBicycles(Customer customer) {
        for (int i=0; i<customer.hiredBicycles.size();i++) {

        }
    }

    public void rentBicycle(String customerID, String bicycleID,Owner owner){
        Customer customer = owner.getCustomer(customerID);
        Bicycle bicycle = owner.getBicycle(bicycleID);
        boolean statusOfBicycle = bicycle.getStatusOfBicycle(bicycle);
        if (statusOfBicycle) {
            customer.hiredBicycles.add(bicycle);
            bicycle.setStatusOfBicycle(bicycle);
            generateInvoice(bicycle, customer);
        } else {
            System.out.println("The bicycle is currently not available");
        }

    }
}
