import constant.OrderLevel;
import error.WrongInputException;

import java.util.Scanner;

public class Screen {
    private OrderLevel orderLevel = OrderLevel.MAIN;        //scanner 계층
    private Hotel hotel = new Hotel();

    public void getInputValue() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String val = sc.next();

                System.out.println();
                System.out.println("=======================================");
                orderLevel = switch (orderLevel) {
                    case MAIN -> main(val);
                    case SELECT_ROOM -> selectRoom(val);
                    case RESERVATIION -> null;
                    case CANCEL -> null;
                    default -> throw new Exception();
                };

            } catch (WrongInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("나주겅");
                System.exit(0);
            }
        }
    }

    public OrderLevel main(String val) throws WrongInputException {
        OrderLevel orderLevel = OrderLevel.MAIN;
        if (val.equals("1")) {
            orderLevel = printRoomList();
        } else if (val.equals("2")) {
//            orderLevel = getMainMenu();
        } else {
            throw new WrongInputException("올바른 값을 입력해주세요.");
        }

        return orderLevel;
    }

    public OrderLevel selectRoom(String val) throws WrongInputException {
        OrderLevel orderLevel = OrderLevel.SELECT_ROOM;
        if (val.equals("1")) {
//            orderLevel = getMainMenu();
        } else if (val.equals("2")) {

        } else {
            throw new WrongInputException("올바른 값을 입력해주세요.");
        }

        return orderLevel;
    }


    public OrderLevel getMainMenu() {
        System.out.println("[ 메뉴 ]");
        System.out.println("1. 예약       2. 예약 확인      3. 예약 취소");

        return OrderLevel.MAIN;
    }

    public OrderLevel printRoomList() {
        System.out.println("예약 가능한 방 목록");
        hotel.getRoomList().stream()
                .forEach(
                        room -> {
                            System.out.print(room.getFloor() + String.format("%02d", room.getUnit()) + " | ");
                            System.out.print(room.getSize() + " | ");
                            System.out.print(room.getPrice() + " 원 \n");
                        }
                );
        return OrderLevel.SELECT_ROOM;
    }

}
