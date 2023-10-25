import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Initializer init = new Initializer();
        init.initRoom();

        UserInformation userInformation = new UserInformation();
        userInformation.Display();
    }
}
