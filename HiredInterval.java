package bicycleRentShop;

import java.time.LocalDateTime;

public class HiredInterval {
    public LocalDateTime hiredTime;
    public LocalDateTime returnedTime;

    public HiredInterval(LocalDateTime hiredTime, LocalDateTime returnedTime) {
        this.hiredTime = hiredTime;
        this.returnedTime = returnedTime;
    }
}
