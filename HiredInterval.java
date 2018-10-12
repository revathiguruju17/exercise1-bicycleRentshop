package bicycleRentShop;

import java.time.LocalDateTime;

public class HiredInterval {
    public LocalDateTime hiredTime;
    public LocalDateTime returnedTime;
    public Double rentedCost;

    public HiredInterval(LocalDateTime hiredTime, LocalDateTime returnedTime, Double rentedCost) {
        this.hiredTime = hiredTime;
        this.returnedTime = returnedTime;
        this.rentedCost = rentedCost;
    }


    String returnAsStringHiredInterval(HiredInterval hiredInterval) {
        return hiredInterval.hiredTime+"  "+hiredInterval.returnedTime+"  "+hiredInterval.rentedCost+"rs";
    }
}
