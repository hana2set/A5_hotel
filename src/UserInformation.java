import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInformation {
    public static Hotel hotel = new Hotel(); //
    public static User user;

    public static void Display() {
        Scanner sc = new Scanner(System.in);
        boolean start = true;
        while(start){
            System.out.println("환영합니다.");
            System.out.println("저희 호텔 방문해 주셔서 감사합니다.");
            System.out.println("1. 고객 메뉴 2. 관리자  3. 종료");

            int menuChoice = sc.nextInt();
            switch (menuChoice) {
                case 1: // 호텔 예약
                    Client();
                    break;
                case 2: // 예약 조회
                    Adimin();
                    break;
                case 3:
                    start = false;
                    break;
                case 4:
                    break;
                default:
                    System.out.println("다시 입력해 주세요");
                    break;
            }
        }
    }
    public static void Client() {
        Scanner sc = new Scanner(System.in);
        boolean start = true;

        System.out.println("고객 정보를 등록합니다.");
        user = savecustomer();
        while (start) {
            System.out.println(user.getName() + " 님 방문해 주셔서 감사합니다.");
            System.out.println("원하는 옵션을 입력해 주세요");
            System.out.println("1.호텔 예약");
            System.out.println("2.예약 조회");
            System.out.println("3.예약 취소");
            System.out.println("4. 종료");
            System.out.println("입력 ->");
            int choiceNumber = sc.nextInt();

            switch (choiceNumber) {
                case 1:
                    reservate(); // 호텔 예약 메소드
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    start = false;
                    break;
            }
        }
    }
    public static void Adimin() {
        Scanner sc = new Scanner(System.in);
        boolean start = true;
        while(start) {
            System.out.println("관리자 모드 입니다.");
            System.out.println("원하는 옵션을 입력해주세요");
            System.out.println("1. 예약 조회");
            System.out.println("2. 종료");
            System.out.println("입력 ->");
            int selectNumber = sc.nextInt();

            switch (selectNumber) {
                case 1:
                    reservationlist();
                    break;
                case 2:
                    start = false;
                    break;
            }
        }
    }



    // 고객 정보 등록
    public static User savecustomer () {
        Scanner sc = new Scanner(System.in);

        System.out.println("고객 정보를 등록합니다.");
        System.out.println("이름을 입력해주세요");
        String name = sc.nextLine();

        System.out.println("전화번호를 입력해주세요:");
        String phone = phoneNumber();

        System.out.println("소지금을 입력해주세요");
        int money = Integer.parseInt(sc.nextLine());

        return new User(name, phone, money);
    }

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

    // 등록된 고객 정보로 호텔 예약
    public static void reservate() {
        Scanner sc = new Scanner(System.in);
        boolean overlap = false; // overlap(중복)
        for (Reservation reservation : hotel.getreservationlist()) {
            if (reservation.getUser().equals(user)) {
                overlap = true; // Set overlap to true if a duplicate is found
            }
        }
        if (overlap) {
            System.out.println("이미 예약 정보가 존재합니다.");
            System.out.println("예약을 취소합니다.");
            System.out.println("2초 후 고객 메뉴로 돌아갑니다.....");

            try {
                for (int i =2; i > 0 ; i++) {
                    System.out.println(i + " ");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return;
        }

        // 예약 시작



    }
    //Admin
    public static void reservationlist() {
        System.out.println("예약 리스트");
        hotel.getreservationlist().forEach((Reservation r) -> {
            System.out.println("예약 번호 : " + hotel.getreservationlist().indexOf(r)+1);
            System.out.println("객실 : " + r.getUuid());
            System.out.println("고객 이름 : " + r.getUser().getName());
            System.out.println("고객 전화번호 : " + r.getUser().getPhoneNumber());
            System.out.println("예약 날짜 : " + r.getDate());
        });
    }

}
