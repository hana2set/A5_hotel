import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Hotel {
    private List<HotelRoom> rooms; // 객실 리스트
    private int hotelAsset; // 호텔 보유 자산(?) 이게 필요한가?
    private Map<UUID, Reservation> reservationMap = new HashMap<>();
    private Map<User, List<UUID>> uuidMap = new HashMap<>();
    private List<Reservation> reservationRoom; // 예약된 객실리스트

    public Hotel() {
        rooms = new ArrayList<>();
        hotelAsset = 0;
        reservationRoom = new ArrayList<>();
    }

    public List<HotelRoom> getRooms() {
        return rooms;
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

            //TODO check availableRoom Login
            availableRoom.add(hotelRoom);
        }
        return availableRoom;
    }

    public Map<UUID, Reservation> getReservationMap() {
        return this.reservationMap;
    }

    // 2개 있는 같은 메서드?
    public List<Reservation> getReservationList(User user) {
        List<UUID> uuids = uuidMap.get(user);
        return uuids == null
                ? Collections.emptyList()
                : uuids.stream()
                .map(id -> reservationMap.get(id))
                .sorted(Comparator.comparing(Reservation::getDate))
                .collect(Collectors.toList());
    }

    public List<Reservation> getReservationList() {
        //TODO master select list
        return Collections.emptyList();
    }

    public UUID addReservation(User user, HotelRoom room, LocalDateTime date) {
        UUID id = UUID.randomUUID();
        reservationMap.put(id, new Reservation(room, user, date));
        return id;
    }
}
