package day01.ex01;

public class User {

    private final Integer id;
    private String name;
    private Integer balance;

    public User(String name, Integer balance) {
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        if (balance == null || balance <= 0)
            this.balance = 0;
        else
            this.balance = balance;
    }

    public Integer getId() { return this.id; }

    public String getName() { return this.name; }

    public Integer getBalance() { return this.balance; }

    public void setName(String name) { this.name = name; }

    public void setBalance(Integer balance) {
        if (balance == null || balance <= 0)
            this.balance = 0;
        else
            this.balance = balance;
    }

    @Override
    public String toString() {
        return name + "(id: " + id + ", balance: " + balance + ")";
    }

}
