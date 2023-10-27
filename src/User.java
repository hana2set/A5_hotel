public class User {
    private String name;
    private String phoneNumber;
    private int money;

    public User(String name, String phone, int money){
        this.name = name;
        this.phoneNumber = phone;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public int getMoney() {
        return money;
    }

    public void subtractMoney(int amount) {
        if (amount > 0 && money >= amount) {
            money -= amount;
        } else {
            System.out.println("소지금이 부족합니다.");
        }
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
