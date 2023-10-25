import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reservation {
    private HotelRoom hotelRoom; // 객실 객체
    private UUID reservationId; // 예약된 방의 UUID;
    private String name; // 고객이름
    private String phoneNumber; // 전화번호
    private String date; // 예약날짜

    public Reservation(UUID reservationId, HotelRoom hotelRoom, String name, String phoneNumber, String date) {
        this.reservationId = reservationId;
        this.hotelRoom = hotelRoom;
        this.name = name;

        // 전화번호가 유효하지 않을 때 예외처리
        if (isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("유효한 전화번호 형태가 아닙니다.");
        }

        // 날짜가 유효하지 않을 때 예외처리
        if (isValidDate(date)) {
            this.date = date;
        } else {
            throw new IllegalArgumentException("유효한 날짜 형태가 아닙니다.");
        }
    }

    // reservationId를 반환하는 메서드
    public UUID getReservationId() {
        return reservationId;
    }

    // 객실을 반환하는 메서드
    public HotelRoom getHotelRoom() {
        return hotelRoom;
    }

    // 이름을 반환하는 메서드
    public String name() {
        return name;
    }

    // 정규식에 맞는 유효한 전화번호인지 확인하는 메서드
    public boolean isValidPhoneNumber(String phoneNumber) {
        // XXX-XXXX-XXXX 형식의 정규 표현식
        String regex = "\\d{3}-\\d{4}-\\d{4}";
        // \d : 숫자를 나타내는 메타 문자로, 0부터 9까지의 숫자 하나를 나타냅니다.

        Pattern pattern = Pattern.compile(regex);
        // Pattern 클래스를 사용하여 정규 표현식을 컴파일하여 pattern 객체를 만듭니다.
        // 이렇게 하면 정규 표현식을 검사하기 위한 패턴이 생성됩니다.

        Matcher matcher = pattern.matcher(phoneNumber);
        // Matcher 클래스를 사용하여 phoneNumber 문자열에 대한 정규 표현식 검사를 수행하는 matcher 객체를 만듭니다.

        return matcher.matches();
        // matcher.matches() 메서드를 사용하여 phoneNumber 문자열이 정규 표현식에 일치하는지 확인합니다.
        // 이 메서드는 전체 문자열이 정규 표현식과 정확히 일치해야 true를 반환하며, 그렇지 않으면 false를 반환합니다.
    }

    // 전화번호를 반환하는 메서드
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // 유효한 날짜인지 확인하는 메서드
    public boolean isValidDate(String date) {
        try {
            // ISO 8601 :  ISO 8601은 날짜와 시간을 표현하기 위한 국제 표준 형식 중 하나로,
            // "yyyy-MM-dd'T'HH:mm:ss"와 같은 형식을 따릅니다.
            LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
            // 주어진 문자열을 날짜형태로 파싱한다
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // 날짜를 반환하는 메서드
    public String getDate() {
        return date;
    }
}