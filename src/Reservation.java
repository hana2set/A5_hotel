import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {
    private UUID uuid;
    private User user;
    private Room room;
    private LocalDateTime date;

    public Reservation(UUID uuid, User user, Room room, LocalDateTime date) {
        this.uuid = uuid;
        this.user = user;
        this.room = room;
        this.date = date;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
