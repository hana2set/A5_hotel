import error.WrongInputException;

import java.time.LocalDateTime;

public class Reservation {
    private User user;
    private Room room;
    private LocalDateTime date;

    public Reservation(User user, Room room, LocalDateTime date) {
        this.user = user;
        this.room = room;
        this.date = date;
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

    public boolean isReservationPossible() throws WrongInputException {

        if (1==1) {

        } else {
            throw new WrongInputException("예약이 불가능합니다.");
        }
        return true;
    }

    private boolean isDateValid() throws WrongInputException {

        if (1==1) {

        } else {
            throw new WrongInputException("올바른 데이터 타입이 아닙니다.");
        }
        return true;
    }

}
