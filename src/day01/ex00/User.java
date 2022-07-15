package day01.ex00;

public class User {

    private Integer id;
    private String name;
    private Integer balance;

    public User(Integer id, String name, Integer balance) {
        this.id = id;
        this.name = name;
        if (balance == null || balance <= 0)
            this.balance = 0;
        else
            this.balance = balance;
    }

    public Integer getId() { return this.id; }

    public String getName() { return this.name; }

    public Integer getBalance() { return this.balance; }

    public void setId(Integer id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setBalance(Integer balance) {
        if (balance == null || balance <= 0)
            this.balance = 0;
        else
            this.balance = balance;
    }

}
