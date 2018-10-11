package bicycleRentShop;

import java.time.LocalDateTime;

public class BicycleRentApplication {
    public static void main(String[] args) {
        Owner owner = new Owner();
        owner.addBicyclesToTheBicyclesList();
        owner.addCustomersToTheCustomerList();
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime returnTime = LocalDateTime.of(2018, 10, 18, 7, 15);
        owner.rentABicycle("customer1", "bicycle1",startTime,returnTime);
    }
}
