import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDateTime;

public class Reservation {
    private HotelRoom hotelRoom;    // 객실
    private User user;              // 고객
    private String reservationDate; // 숙박일자
    private LocalDateTime date;     // 예약일자

    public Reservation(HotelRoom hotelRoom, User user, String reservationDate) throws Exception {
        this.hotelRoom = hotelRoom;
        this.user = user;
        this.reservationDate = reservationDate;
        this.date = LocalDateTime.now();
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public HotelRoom getHotelRoom() {
        return hotelRoom;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getDate() {
        return date;
    }
}