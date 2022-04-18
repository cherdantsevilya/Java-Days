package day01.ex03;

import java.util.UUID;

public class Program {

    public static void main(String[] args) {

        User john = new User("John", 5345);
        User mike = new User("Mike", 2342);

        UUID id1 = UUID.randomUUID();
        Transaction t1 = new Transaction(id1, mike, john, TransferCategory.debit, 500);
        UUID id2 = UUID.randomUUID();
        Transaction t2 = new Transaction(id2, mike, john, TransferCategory.debit, 4231);
        UUID id3 = UUID.randomUUID();
        Transaction t3 = new Transaction(id3, john, mike, TransferCategory.debit, 5);
        System.out.println();

        TransactionsLinkedList list = new TransactionsLinkedList();

        list.addTransaction(t1);
        list.addTransaction(t2);

        Transaction[] arr = list.toArray();
        for (int i = 0; i < arr.length; i++)
            System.out.println("arr[" + i + "] uuid = " + arr[i].getId());
        System.out.println();

        list.delTransaction(id1);
        Transaction[] arr1 = list.toArray();
        for (int i = 0; i < arr1.length; i++)
            System.out.println("arr1[" + i + "] uuid = " + arr1[i].getId());
        System.out.println();

        list.delTransaction(id3);

    }
}
