package day01.ex00;

import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        User john = new User(1, "John", 1000000);
        User mike = new User(2, "Mike", 215);

        UUID x = UUID.randomUUID();
        Transaction transaction1 = new Transaction(x, john, mike, TransferCategory.DEBIT, 100);
        System.out.println(transaction1);
        System.out.println();

        Transaction transaction2 = new Transaction(x, john, mike, TransferCategory.CREDIT, 1000000);
        System.out.println(transaction2);
        System.out.println();

        UUID y = UUID.randomUUID();
        Transaction transaction3 = new Transaction(y, mike, john, TransferCategory.DEBIT, 1000001);
        System.out.println(transaction3);
        System.out.println();

        Transaction transaction4 = new Transaction(y, mike, john, TransferCategory.DEBIT, 0);
        System.out.println(transaction4);
        System.out.println();
    }
}
