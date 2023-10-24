import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Hotel {
    private List<Room> roomList = new ArrayList<>();
    private BigDecimal asset = new BigDecimal("100000000000");

    public List<Reservation> reservationList = new ArrayList<>();

    public List<Room> getRoomList() {
        return roomList;
    }

    public List<Reservation> getReservationList() {
        return this.reservationList;
    }

    public List<Reservation> getReservationList(List<UUID> uuids) {
        return uuids == null
                ? Collections.emptyList()
                : this.reservationList.stream()
                    .filter(rsv -> uuids.contains(rsv.getUuid()))
                    .toList();
    }

}
