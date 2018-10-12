package bicycleRentShop;

public class BicycleRentApplication {
    public static void main(String[] args) {
        Owner owner = new Owner();
        owner.addBicyclesToTheBicyclesList();
        ApplicationDriver applicationDriver = new ApplicationDriver();
        applicationDriver.startApplication(owner);
    }
}
