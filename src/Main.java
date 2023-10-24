import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Initializer init = new Initializer();
        init.initRoom();

        // 메뉴화면 띄우기
        // 데이터 입력받기
        Screen screen = new Screen();
        screen.getMainMenu();
        screen.getInputValue(); //scanner loop

    }
}
