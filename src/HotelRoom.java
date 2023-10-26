public class HotelRoom {
    private int unit;           // 호실
    private String roomSize;    // 객실 사이즈
    private int price;          // 객실 비용

    public HotelRoom(int unit, String roomSize, int price) {
        this.unit = unit;
        this.roomSize = roomSize;
        this.price = price;
    }

    public int getUnit() {
        return unit;
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
