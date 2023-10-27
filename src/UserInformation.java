import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserInformation {
    public static Hotel hotel = new Hotel();
    public static User user;

    public static void Display() {
        Scanner sc = new Scanner(System.in);
        boolean start = true;
        while(start){

            System.out.println("=============환영합니다=============");
            System.out.println("저희 A5 호텔에 방문해 주셔서 감사합니다.");
            System.out.println("1. 고객 메뉴 2. 관리자  3. 종료");
            System.out.println("==================================");

            int menuChoice = sc.nextInt();
            switch (menuChoice) {
                case 1: // 호텔 예약
                    clientMenu();
                    break;
                case 2: // 예약 조회
                    adiminMenu();
                    break;
                case 3: // 종료
                    System.out.println("종료합니다.\n");
                    start = false;
                    break;
                default:
                    System.out.println("다시 입력해 주세요\n");
                    break;
            }
        }
    }

    public static void clientMenu() {
        Scanner sc = new Scanner(System.in);
        boolean start = true;
        user = saveCustomer();

        while (start) {
            System.out.println("==================================");
            System.out.println(user.getName() + " 님 방문해 주셔서 감사합니다.");
            System.out.println("원하는 옵션을 입력해 주세요");
            System.out.println("1. 호텔 예약");
            System.out.println("2. 예약 조회");
            System.out.println("3. 예약 취소");
            System.out.println("4. 이전화면");
            System.out.println("==================================");
            int choiceNumber = sc.nextInt();

            switch (choiceNumber) {
                case 1: // 호텔 예약
                    System.out.println("숙박하실 날짜를 입력해주세요 yyyy-MM-dd");
                    String date = sc.next();

                    LocalDateTime reservationDate;

                    try {
                        reservationDate = LocalDateTime.parse(date + "T00:00:00", DateTimeFormatter.ISO_DATE_TIME);
                    } catch (DateTimeParseException e) {
                        System.out.println("유효하지 않은 날짜 형식입니다.");
                        break;
                    }

                    System.out.println("숙박하실 방을 입력해주세요");
                    int roomNumber = sc.nextInt();

                    break;
                case 2: // 예약 조회
                    // TODO hotel.getReservationByUser();

                    break;
                case 3: // 예약 취소
                    // TODO hotel.cancelReservationByUser();

                    break;
                case 4:
                    System.out.println("이전화면으로 돌아갑니다.\n");
                    start = false;
                    break;
            }
        }
    }

    public static void adiminMenu() {
        Scanner sc = new Scanner(System.in);
        boolean start = true;
        while(start) {
            System.out.println("==================================");
            System.out.println("관리자 모드 입니다.");
            System.out.println("원하는 옵션을 입력해주세요");
            System.out.println("1. 예약 조회");
            System.out.println("2. 호텔 자산 조회");
            System.out.println("3. 이전화면");
            System.out.println("==================================");
            int selectNumber = sc.nextInt();


            switch (selectNumber) {
                case 1: // 예약 조회
                    System.out.println("현재 호텔 객실의 예약 상태입니다.");
                    // TODO hotel.getReservationList()
                    hotel.getReservationList();
                    System.out.println("1. 이전화면\n");
                    int returnChoice = sc.nextInt();
                    break;
                case 2: // 호텔 자산 조회
                    hotel.printHotelMoney();
                    System.out.println("1. 이전화면\n");
                    returnChoice = sc.nextInt();
                    break;
                case 3: // 이전화면
                    System.out.println("이전화면으로 돌아갑니다.\n");
                    start = false;
                    break;
            }
        }
    }

    // 고객 정보 등록
    public static User saveCustomer () {
        Scanner sc = new Scanner(System.in);

        System.out.println("고객 정보를 등록합니다.");
        System.out.println("이름을 입력해주세요.");
        String name = sc.nextLine();

        System.out.println("전화번호를 입력해주세요. (- 포함)");
        System.out.println("예시 : 010-XXXX-XXXX");
        String phone = phoneNumber();

        System.out.println("소지금을 입력해주세요.");
        int money = Integer.parseInt(sc.nextLine());

        return new User(name, phone, money);
    }

    //TODO 형식을 print로 보여주던지, 폰번호를 파싱하던지 해야함 ( 01012342345 -> 에러 )
    public static String phoneNumber(){
        Scanner sc = new Scanner(System.in);
        String rule = "^\\d{3}-\\d{3,4}-\\d{4}$";
        boolean check = false;
        String phoneNumber = ""; // 폰 번호 초기화 // 정규식 패턴 일치 확인

        while(!check) {
            phoneNumber = sc.nextLine();
            if (phoneNumber.matches(rule)) {
                check = true;
            } else {
                System.out.println("유효하지 않은 전화번호 형식입니다. 다시 시도하세요.");
            }
        }
        return phoneNumber;
    }
}
