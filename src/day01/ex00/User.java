package day01.ex00;

public class User {

    private int id;
    private String name;
    private int balance;

    public User(int id, String name, int balance) {
        this.id = id;
        this.name = name;
        if (balance > 0)
            this.balance = balance;
        else
            this.balance = 0;
    }

    public int getId() { return this.id; }

    public String getName() { return this.name; }

    public int getBalance() { return this.balance; }

    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setBalance(int balance) { this.balance = balance; }

}
