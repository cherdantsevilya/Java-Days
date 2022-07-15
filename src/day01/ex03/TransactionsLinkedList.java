package day01.ex03;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private final Transaction start = new Transaction();
    private final Transaction finish = new Transaction();
    private Integer numOfListElements;

    public TransactionsLinkedList() {
        start.setNext(finish);
        finish.setPrev(start);
        numOfListElements = 0;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transaction.setNext(finish);
        transaction.setPrev(finish.getPrev());
        finish.getPrev().setNext(transaction);
        finish.setPrev(transaction);
        numOfListElements++;
    }

    @Override
    public void delTransaction(UUID id) {
        for (Transaction tmp = start.getNext(); tmp != finish; tmp = tmp.getNext()) {
            if (tmp.getId().equals(id)) {
                tmp.getPrev().setNext(tmp.getNext());
                tmp.getNext().setPrev(tmp.getPrev());
                numOfListElements--;
                return ;
            }
        }
        throw new TransactionNotFoundException("Transaction with UUID - " + id + " not found");
    }

    @Override
    public Transaction[] toArray() {
        Transaction tmp = start.getNext();
        Transaction[] array = new Transaction[numOfListElements];
        for (int i = 0; i < numOfListElements; i++) {
            array[i] = tmp;
            tmp = tmp.getNext();
        }
        return array;
    }

}
