package day01.ex03;

public class User {

    private final int id;
    private String name;
    private int balance;
    private TransactionsList transactionsList;

    public User(String name, int balance) {
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        if (balance > 0)
            this.balance = balance;
        else
            this.balance = 0;
        this.transactionsList = null;
    }

    public int getId() { return this.id; }

    public String getName() { return this.name; }

    public int getBalance() { return this.balance; }

    public TransactionsList getTransactionsList() {
        return transactionsList;
    }

    public void setName(String name) { this.name = name; }

    public void setBalance(int balance) { this.balance = balance; }

    public void setTransactionsList(TransactionsList transactionsList) {
        this.transactionsList = transactionsList;
    }

    @Override
    public String toString() {
        return name + "(id: " + id + ", balance: " + balance + ")";
    }

}
