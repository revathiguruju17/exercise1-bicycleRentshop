package bicycleRentShop;

import java.time.LocalDateTime;

public class RentedTime {
    LocalDateTime startTime;
    LocalDateTime endTime;

    public RentedTime(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
