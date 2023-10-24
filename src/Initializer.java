import constant.RoomSize;

public class Initializer {
    public void initRoom() {
        Hotel hotel = new Hotel();
        hotel.getRoomList().add(new Room(1, 1, RoomSize.SINGLE, 300000));
        hotel.getRoomList().add(new Room(1, 2, RoomSize.SINGLE, 300000));
        hotel.getRoomList().add(new Room(1, 3, RoomSize.SINGLE, 320000));
        hotel.getRoomList().add(new Room(1, 4, RoomSize.SINGLE, 320000));
        hotel.getRoomList().add(new Room(2, 1, RoomSize.DOUBLE, 500000));
        hotel.getRoomList().add(new Room(2, 2, RoomSize.DOUBLE, 500000));
        hotel.getRoomList().add(new Room(2, 3, RoomSize.DOUBLE, 500000));
        hotel.getRoomList().add(new Room(2, 4, RoomSize.DOUBLE, 500000));


    }
}
