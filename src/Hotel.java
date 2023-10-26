import java.time.LocalDate;
import java.util.*;

public class Hotel {
    private List<HotelRoom> rooms;      // 객실 리스트
    private int hotelAsset;             // 호텔 보유 자산
    private Map<UUID, Reservation> reservationMap = new HashMap<>();    // UUID - 예약
//    private Map<User, List<UUID>> uuidMap = new HashMap<>();            // 고객별별 uuids 리스트

    public Hotel() {
        rooms = new ArrayList<>();
        hotelAsset = 0;
    }

    public int getHotelAsset() {
        return hotelAsset;
    }

    public List<HotelRoom> getRooms() {
        return rooms;
    }

    // 예약 가능한 객실 리스트를 반환하는 메서드
    public List<HotelRoom> getAvailableRoom(String desiredDate) {
        List<HotelRoom> availableRoom = new ArrayList<>();
        LocalDate desiredLocalDate = LocalDate.parse(desiredDate);

        for (HotelRoom hotelRoom : rooms) {
            boolean isRoomAvailable = true;

            for (Reservation reservation : reservationMap.values()) {
                LocalDate reservationLocalDate = reservation.getDate().toLocalDate();
                if (reservation.getHotelRoom() == hotelRoom && reservation.getDate().toLocalDate().isEqual(desiredLocalDate)) {
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

    // 고객 예약조회
    public void getReservationByUser() {
        System.out.println("예약번호를 입력하세요: ");

        Scanner sc = new Scanner(System.in);
        String data = sc.next();
        try {
            UUID uuid = UUID.fromString(sc.next());

            Reservation reservation = reservationMap.get(uuid);
            if (reservation == null) {
                System.out.println("잘못된 예약 번호입니다. :" + data);
            } else {
                System.out.println("숙박일자 : " + reservation.getReservationDate());
                System.out.println("예약자명 : " + reservation.getUser().getName());
                System.out.println("전화번호 : " + reservation.getUser().getPhoneNumber());
                System.out.println("방　번호 : " + reservation.getHotelRoom().getUnit());
                System.out.println("방　크기 : " + reservation.getHotelRoom().getRoomSize());
                System.out.println("가　　격 : " + reservation.getHotelRoom().getPrice() + " 원");
                System.out.println("예약일자 : " + reservation.getDate());
                System.out.println("예약번호 : " + data);
            }

        } catch (Exception e) {
            System.out.println("잘못된 예약 번호입니다. :" + data);
        }
    }

    // uuid로 예약 조회하기
    public void getReservationList(UUID uuid) {
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
    }

    // 전체 예약 조회 (관리자)
    public void getReservationList() {
        List<UUID> keyset = new ArrayList<>(reservationMap.keySet());
        for (UUID uuid : keyset) {
            getReservationList(uuid);
            System.out.println("===========================================");
            System.out.println();
        }

    }

    // 예약 추가
    public UUID addReservation(User user, HotelRoom room, String reservationDate) throws Exception {

        UUID id = UUID.randomUUID();
        reservationMap.put(id, new Reservation(room, user, reservationDate));
//        if (uuidMap.get(user) == null) {
//            uuidMap.put(user, new ArrayList<>());
//        }
//        uuidMap.get(user).add(id);

        return id;
    }

    public void cancelReservationByUser() {
        System.out.println("예약번호를 입력하세요: ");

        Scanner sc = new Scanner(System.in);
        String data = sc.next();
        try {
            UUID uuid = UUID.fromString(sc.next());

            Reservation reservation = reservationMap.get(uuid);
            if (reservation == null) {
                System.out.println("잘못된 예약 번호입니다. :" + data);
            } else {
                reservationMap.remove(uuid);
//            for (User user : uuidMap.keySet()) {
//                if (uuidMap.get(user).stream()
//                        .filter(i -> i == UUID.fromString(uuid))
//                        .findFirst()
//                        .isPresent() == true) {
//                    uuidMap.get(user).remove(uuid);
//                    return;
//                }
//            }
            }
        } catch (Exception e) {
            System.out.println("잘못된 예약 번호입니다. :" + data);
        }

    }

    public void printHotelMoney() {
        System.out.println("호텔 자산 : " + getHotelAsset());
    }

    // 호텔 자산의 증가 & 감소
    public void addHotelMoney(int hotelMoney){
        this.hotelAsset += hotelAsset;
    }
    public void loseHotelMoney(int hotelMoney) {
        this.hotelAsset -= hotelAsset;
    }
}
