import java.time.LocalDate;
import java.time.LocalDateTime;

public class Initializer {
    public void run() {
        HotelRoom room1 = new HotelRoom(101, "SINGLE", 300000);
        HotelRoom room2 = new HotelRoom(102, "SINGLE", 300000);
        HotelRoom room3 = new HotelRoom(103, "SINGLE", 320000);
        HotelRoom room4 = new HotelRoom(104, "SINGLE", 320000);
        HotelRoom room5 = new HotelRoom(201, "DOUBLE", 500000);
        HotelRoom room6 = new HotelRoom(202, "DOUBLE", 500000);
        HotelRoom room7 = new HotelRoom(203, "DOUBLE", 500000);
        HotelRoom room8 = new HotelRoom(204, "DOUBLE", 500000);

        UserInformation.hotel.getRooms().add(room1);
        UserInformation.hotel.getRooms().add(room2);
        UserInformation.hotel.getRooms().add(room3);
        UserInformation.hotel.getRooms().add(room4);
        UserInformation.hotel.getRooms().add(room5);
        UserInformation.hotel.getRooms().add(room6);
        UserInformation.hotel.getRooms().add(room7);
        UserInformation.hotel.getRooms().add(room8);

        User user1 = new User("김영규", "010-0235-9797", 340223300);
        User user2 = new User("고호텔", "010-1234-1234", 12323200);
        User user3 = new User("가가가", "111-1111-1111", 400000);

        try {
            UserInformation.hotel.addReservation(user1, room1, LocalDateTime.now());
            UserInformation.hotel.addReservation(user1, room2, LocalDate.of(2023,11,20).atStartOfDay());
            UserInformation.hotel.addReservation(user1, room3, LocalDate.of(2023,11,21).atStartOfDay());
            UserInformation.hotel.addReservation(user1, room3, LocalDate.of(2023,11,22).atStartOfDay());
            UserInformation.hotel.addReservation(user2, room1, LocalDate.of(2023,11,19).atStartOfDay());
            UserInformation.hotel.addReservation(user2, room2, LocalDate.of(2023,11,21).atStartOfDay());
            UserInformation.hotel.addReservation(user2, room3, LocalDate.of(2023,11,19).atStartOfDay());
            UserInformation.hotel.addReservation(user2, room6, LocalDate.of(2023,11,10).atStartOfDay());
            UserInformation.hotel.addReservation(user2, room6, LocalDate.of(2023,11,11).atStartOfDay());
            UserInformation.hotel.addReservation(user2, room6, LocalDate.of(2023,11,12).atStartOfDay());
            UserInformation.hotel.addReservation(user3, room1, LocalDate.of(2023,11,1).atStartOfDay());
            UserInformation.hotel.addReservation(user3, room1, LocalDate.of(2023,12,1).atStartOfDay());
            UserInformation.hotel.addReservation(user3, room1, LocalDate.of(2023,12,2).atStartOfDay());
        } catch (Exception e) {
            System.out.println("초기화 부분 에러");
        }

    }
}
