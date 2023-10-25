public class HotelRoom {
    private String roomSize; // 객실 사이즈
    private int price; // 객실 비용

    public HotelRoom(String roomSize, int price) {
        this.roomSize = roomSize;
        this.price = price;
    }

    // 객실 사이즈 반환하는 메서드
    public String getRoomSize() {
        return roomSize;
    }

    // 객실 비용을 반환하는 메서드
    public int getPrice() {
        return price;
    }

}
