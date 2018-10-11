package bicycleRentShop;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Bicycle {
    final String bicycleID;
    private final int rentPerHour;
    private boolean isAvailable = true;

    Bicycle(String bicycleID, int rentPerHour) {
        this.bicycleID = bicycleID;
        this.rentPerHour = rentPerHour;
    }

    double calculateRent(Bicycle bicycle, LocalDateTime startingTime, LocalDateTime endingTime) {
        double diffInMinutes = ChronoUnit.MINUTES.between(startingTime, endingTime);
        return diffInMinutes * bicycle.rentPerHour / 60;
    }

    void displayTheBicycle(Bicycle bicycle) {
        System.out.println(bicycle.bicycleID + " " + bicycle.rentPerHour + "rs/hour " + isAvailable);
    }

    boolean getStatusOfBicycle(Bicycle bicycle) {
        return bicycle.isAvailable;
    }

    void setStatusOfBicycle(Bicycle bicycle) {
        if (bicycle.isAvailable) {
            bicycle.isAvailable = false;
        } else {
            bicycle.isAvailable = true;
        }
    }
}
