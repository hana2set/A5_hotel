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

    public void setMoney(int money) {
        this.money = money;
    }

}
