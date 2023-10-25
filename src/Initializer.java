public class Initializer {
    public void initRoom() {
        UserInformation.hotel.getRooms().add(new HotelRoom(101, "SINGLE", 300000));
        UserInformation.hotel.getRooms().add(new HotelRoom(102, "SINGLE", 300000));
        UserInformation.hotel.getRooms().add(new HotelRoom(103, "SINGLE", 320000));
        UserInformation.hotel.getRooms().add(new HotelRoom(104, "SINGLE", 320000));
        UserInformation.hotel.getRooms().add(new HotelRoom(201, "DOUBLE", 500000));
        UserInformation.hotel.getRooms().add(new HotelRoom(202, "DOUBLE", 500000));
        UserInformation.hotel.getRooms().add(new HotelRoom(203, "DOUBLE", 500000));
        UserInformation.hotel.getRooms().add(new HotelRoom(204, "DOUBLE", 500000));
    }
}
