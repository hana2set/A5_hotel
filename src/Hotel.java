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

    public int getHotelAsset() {
        return hotelAsset;
    }

    public List<HotelRoom> getRooms() {
        return rooms;
    }

    // 객실리스트에 객실을 추가하는 메서드
    public void addRoom(HotelRoom room) {
        rooms.add(room);
        hotelAsset += room.getPrice(); // 호텔 자산에 객실 가격이 추가됨(필수 사항 아님)
    }

    // 예약 가능한 객실 리스트를 반환하는 메서드
    public List<HotelRoom> getAvailableRoom(LocalDateTime desiredDate) {
        List<HotelRoom> availableRoom = new ArrayList<>();

        for (HotelRoom hotelRoom : rooms) {
            boolean isRoomAvailable = true;

            for (Reservation reservation : reservationMap.values()) {
                if (reservation.getHotelRoom() == hotelRoom && reservation.getDate().toLocalDate().isEqual(desiredDate.toLocalDate())) {
                    isRoomAvailable = false;
                    break; // 예약 불가능
                }
            }

            if (isRoomAvailable) {
                availableRoom.add(hotelRoom);
            }
        }

        return availableRoom;
    }


    public Map<UUID, Reservation> getReservationMap() {
        return this.reservationMap;
    }

    // 2개 있는 같은 메서드?
//    public List<Reservation> getReservationList(User user) {
//        List<UUID> uuids = uuidMap.get(user);
//        return uuids == null
//                ? Collections.emptyList()
//                : uuids.stream()
//                .map(reservationMap::get)
//                .sorted(Comparator.comparing(Reservation::getDate, Comparator.nullsLast(Comparator.reverseOrder())))
//                .collect(Collectors.toList());
//    }

    public void getReservationList(UUID uuid) {
        System.out.println("예약번호를 입력하세요: ");

        Scanner sc = new Scanner(System.in);
        String tempBookingId = sc.next();

        Reservation reservation = reservationMap.get(uuid);
        if (reservation == null) {
            System.out.println("잘못된 예약 번호입니다. :" + uuid);
        } else {
            System.out.println("숙박일자 : " + reservation.getReservationDate());
            System.out.println("예약자명 : " + reservation.getUser().getName());
            System.out.println("전화번호 : " + reservation.getUser().getPhoneNumber());
            System.out.println("방　번호 : " + reservation.getHotelRoom().getUnit());
            System.out.println("방　크기 : " + reservation.getHotelRoom().getRoomSize());
            System.out.println("가　　격 : " + reservation.getHotelRoom().getPrice() + " 원");
            System.out.println("예약일자 : " + reservation.getDate());
            System.out.println("예약번호 : " + uuid);
        }

        sc.close();
    }

    public void getReservationList() {
//        List<Reservation> reservationList =  reservationMap.values().stream()
//                .sorted(Comparator.comparing(Reservation::getDate, Comparator.nullsLast(Comparator.reverseOrder())))
//                .collect(Collectors.toList());

        List<UUID> keyset = new ArrayList<>(reservationMap.keySet());
        for(UUID uuid: keyset){
            getReservationList(uuid);
            System.out.println("===========================================");
            System.out.println();
        }

    }

    public UUID addReservation(User user, HotelRoom room, LocalDateTime date) throws Exception {
        UUID id = UUID.randomUUID();

        // 중복날짜, room 있는지 확인
        if (reservationMap.values().stream()
                .filter((rsv) -> room == rsv.getHotelRoom() && rsv.getDate().equals(date))
                .findFirst()
                .isPresent() == true )
            throw new Exception("이미 예약된 날짜가 존재합니다.");

        reservationMap.put(id, new Reservation(room, user, date));
        if (uuidMap.get(user) == null) {
            uuidMap.put(user, new ArrayList<>());
        }
        uuidMap.get(user).add(id);


        return id;
    }

    public void cancelReservation(User user) {
        if (uuidMap.get(user) != null) {
            uuidMap.get(user).stream().forEach(reservationMap::remove);
        }
        uuidMap.remove(user);
    }

    public void cancelReservation(User user, UUID uuid) {
        reservationMap.remove(uuid);
        if (uuidMap.get(user) != null) {
            uuidMap.get(user).remove(uuid);
        }
    }

    public void cancelReservation(UUID p_uuid) {
        reservationMap.remove(p_uuid);
        for (User user : uuidMap.keySet()) {
            if (uuidMap.get(user).stream()
                    .filter(uuid -> uuid == p_uuid)
                    .findFirst()
                    .isPresent() == true) {
                uuidMap.get(user).remove(p_uuid);
                return;
            }
        }
    }

    public void printHotelMoney(){
        System.out.println("호텔 자산 : " + getHotelAsset());
    }
}
