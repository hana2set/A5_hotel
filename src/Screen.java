import constant.OrderLevel;
import error.WrongInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Screen {
    private OrderLevel orderLevel = OrderLevel.MAIN;        //주문 계층

    public void getInputValue() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println();
                String val = sc.next();

                System.out.println();
                System.out.println("=======================================");
                orderLevel = switch (orderLevel) {
                    case MAIN -> main(val);
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

        return orderLevel;
    }

    public OrderLevel getMainMenu() {
        System.out.println("[ 메뉴 ]");
        System.out.println("1. 예약       2. 예약 확인      3. 예약 취소");

        return OrderLevel.MAIN;
    }
}
