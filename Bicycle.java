package bicycleRentShop;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Bicycle {
    final String bicycleID;
    final int rentPerHour;
    private boolean isAvailable = true;

    Bicycle(String bicycleID, int rentPerHour) {
        this.bicycleID = bicycleID;
        this.rentPerHour = rentPerHour;
    }

    double calculateRent(Bicycle bicycle, HiredInterval hiredInterval) {
        hiredInterval.returnedTime = LocalDateTime.now();
        double diffInMinutes = ChronoUnit.MINUTES.between(hiredInterval.hiredTime,hiredInterval.returnedTime);
        return diffInMinutes * bicycle.rentPerHour / 60;
    }

    void displayTheBicycle(Bicycle bicycle) {
        System.out.print(bicycle.bicycleID + "  " + bicycle.rentPerHour + "rs/hour  ");
        if(bicycle.isAvailable){
            System.out.println("available");
        }
        else {
            System.out.println("Not available");
        }
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
