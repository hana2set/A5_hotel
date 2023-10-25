import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<HotelRoom> rooms; // 객실 리스트
    private int hotelAsset; // 호텔 보유 자산(?) 이게 필요한가?
    private List<Reservation> reservationRoom; // 예약된 객실리스트

    public Hotel() {
        rooms = new ArrayList<>();
        hotelAsset = 0;
        reservationRoom = new ArrayList<>();
    }

    // 객실리스트에 객실을 추가하는 메서드
    public void addRoom(HotelRoom room) {
        rooms.add(room);
        hotelAsset += room.getPrice(); // 호텔 자산에 객실 가격이 추가됨(필수 사항 아님)
    }

    // 예약 가능한 객실리스트를 반환하는 메서드
    public List<HotelRoom> getAvailableRoom() {
        List<HotelRoom> availableRoom = new ArrayList<>(); // 예약 가능한 객실 리스트
        for (HotelRoom hotelRoom : rooms) {
            if(!hotelRoom.isBooked()) {
                availableRoom.add(hotelRoom);
            }
        }
        return availableRoom;
    }

    public List<Reservation> getreservationlist() {
        return this.getreservationlist();
    }
}
