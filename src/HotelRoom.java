import java.util.UUID;

public class HotelRoom {
    private String roomSize; // 객실 사이즈
    private int price; // 객실 비용
    private boolean isBooked; // 예약이 되어있는지

    public HotelRoom(String roomSize, int price) {
        this.roomSize = roomSize;
        this.price = price;
        this.isBooked = false; // 처음에는 빈 객실
    }

    // 객실 사이즈 반환하는 메서드
    public String getRoomSize() {
        return roomSize;
    }

    // 객실 비용을 반환하는 메서드
    public int getPrice() {
        return price;
    }

    // 객실이 예약되어있는지를 확인하는 메서드
    public boolean isBooked() {
        return isBooked;
    }
}
