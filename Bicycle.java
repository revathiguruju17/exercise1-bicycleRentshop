package bicycleRentShop;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Bicycle {
     String bicycleID;
     int rentPerHour;
    private boolean isAvailable = true;

    Bicycle(String bicycleID, int rentPerHour) {
        this.bicycleID = bicycleID;
        this.rentPerHour = rentPerHour;
    }

    private OutputDriver outputDriver = new OutputDriver();

    double calculateRent(Bicycle bicycle, HiredInterval hiredInterval) {
        hiredInterval.returnedTime = LocalDateTime.now();
        double diffInSeconds = ChronoUnit.SECONDS.between(hiredInterval.hiredTime, hiredInterval.returnedTime);
        return diffInSeconds * bicycle.rentPerHour/3600;
    }

    void displayTheBicycle(Bicycle bicycle) {
        outputDriver.printBicycleDetails(bicycle.bicycleID,bicycle.rentPerHour,bicycle.isAvailable);
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

    boolean compareTobicycleObjects(Bicycle bicycle1, Bicycle bicycle2){
        if(bicycle1.equals(bicycle2)){
            return true;
        }
        return false;
    }

    String displayTheHiredBicycleForInvoice(Bicycle bicycle) {
        return bicycle.bicycleID+"  "+bicycle.rentPerHour;
    }
}
