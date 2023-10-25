import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDateTime;

public class Reservation {
    private HotelRoom hotelRoom; // 객실 객체
    private User user;
    private LocalDateTime date; // 예약날짜

    public Reservation(HotelRoom hotelRoom, User user, LocalDateTime date) {
        this.hotelRoom = hotelRoom;
        this.user = user;
        this.date = date;
    }

    public Reservation(HotelRoom hotelRoom, User user, String date) throws Exception {
        this.hotelRoom = hotelRoom;
        this.user = user;
        try {
            // ISO 8601 :  ISO 8601은 날짜와 시간을 표현하기 위한 국제 표준 형식 중 하나로,
            // "yyyy-MM-dd'T'HH:mm:ss"와 같은 형식을 따릅니다.
            this.date = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
            // 주어진 문자열을 날짜형태로 파싱한다
        } catch (DateTimeParseException e) {
            throw new Exception(e.getMessage());
        }
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