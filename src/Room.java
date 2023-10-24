import constant.RoomSize;

public class Room {
    private int floor;
    private int unit;
    private RoomSize size;
    private int price;

    public Room(int floor, int unit, RoomSize size, int price) {
        this.floor = floor;
        this.unit = unit;
        this.size = size;
        this.price = price;
    }

    public int getFloor() {
        return floor;
    }

    public int getUnit() {
        return unit;
    }

    public RoomSize getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
