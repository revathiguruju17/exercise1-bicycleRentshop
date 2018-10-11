package bicycleRentShop;

import java.time.LocalDateTime;

public class BicycleRentApplication {
    public static void main(String[] args) {
        Owner owner = new Owner();
        owner.addBicyclesToTheBicyclesList();
        owner.displayTheListOfBicycles();
        System.out.println();
        owner.addCustomersToTheCustomerList();
        LocalDateTime startTime = LocalDateTime.of(2018,10,17,7,15);
        LocalDateTime returnTime = LocalDateTime.of(2018, 10, 18, 7, 15);
        owner.rentABicycle("customer1", "bicycle1",startTime,returnTime);
        owner.rentABicycle("customer2","bicycle2",startTime,returnTime);
        owner.returnABicycle("customer1","bicycle1");
        owner.displayTheListOfBicycles();
        System.out.println();
        owner.hiredBicyclesByOneCustomer("customer1");
    }
}
