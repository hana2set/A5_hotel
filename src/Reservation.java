import java.time.OffsetDateTime;
import java.util.UUID;

public class Reservation {
    private UUID id; // 예약번호
    private User user; // 고객
    private OffsetDateTime date;

    public Reservation(User user){
        this.id = UUID.randomUUID();
        this.user = user;
        this.date = date;

    }
    public UUID getUuid() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public OffsetDateTime getDate() {
        return this.date;
    }




}
