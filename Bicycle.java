package bicycleRentShop;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Bicycle {
    final String bicycleID;
    final int rentPerHour;
    boolean isAvailable = true;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bicycle)) return false;
        Bicycle bicycle = (Bicycle) o;
        return rentPerHour == bicycle.rentPerHour &&
                isAvailable == bicycle.isAvailable &&
                Objects.equals(bicycleID, bicycle.bicycleID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bicycleID, rentPerHour, isAvailable);
    }
}
