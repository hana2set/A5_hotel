import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Hotel {
    private List<Room> roomList = new ArrayList<>();
    private BigDecimal asset = new BigDecimal("100000000000");
    private Map<UUID, Reservation> reservationMap = new HashMap<>();


    public List<Room> getRoomList() {
        return roomList;
    }

    public Map<UUID, Reservation> getReservationMap() {
        return this.reservationMap;
    }

    public List<Reservation> getReservationList(List<UUID> uuids) {
        return uuids == null
                ? Collections.emptyList()
                : uuids.stream()
                    .map(id -> reservationMap.get(id))
                    .sorted(Comparator.comparing(Reservation::getDate))
                    .toList();
    }

    public UUID addReservation(User user, Room room, LocalDateTime date) {
        UUID id = UUID.randomUUID();
        reservationMap.put(id, new Reservation(id, user, room, date));
        return id;
    }

}
