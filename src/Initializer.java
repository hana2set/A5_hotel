public class Initializer {
    public void initRoom() {
        Hotel hotel = new Hotel();
        hotel.getRoomList().add(new Room(1, 1, 4, 300000));
        hotel.getRoomList().add(new Room(1, 2, 4, 300000));
        hotel.getRoomList().add(new Room(1, 3, 4, 320000));
        hotel.getRoomList().add(new Room(1, 4, 4, 320000));
        hotel.getRoomList().add(new Room(2, 1, 8, 500000));
        hotel.getRoomList().add(new Room(2, 2, 8, 500000));
        hotel.getRoomList().add(new Room(2, 3, 8, 500000));
        hotel.getRoomList().add(new Room(2, 4, 8, 500000));


    }
}
