package day01.ex03;

import java.util.UUID;

enum TransferCategory {
    debit,
    credit
}

public class Transaction {

    private UUID id;
    private User recipient;
    private User sender;
    private TransferCategory transferCategory;
    private int transferAmount;
    private Transaction next;
    private Transaction prev;

    public Transaction() {}

    public Transaction(UUID id, User recipient, User sender, TransferCategory transferCategory, int transferAmount) {
        this.id = id;
        this.recipient = recipient;
        this.sender = sender;
        this.transferCategory = transferCategory;
        this.transferAmount = transferAmount;
        this.next = null;
        this.prev = null;
        if (!checkTransfer())
            return ;
        sender.setBalance(sender.getBalance() - transferAmount);
        recipient.setBalance(recipient.getBalance() + transferAmount);
        System.out.println(sender.getName() + " -> " + recipient.getName() + ", -" + transferAmount + ", OUTCOME, transaction " + getId());
        System.out.println(recipient.getName() + " -> " + sender.getName() + ", +" + transferAmount + ", INCOME, transaction " + getId());
    }

    public UUID getId() { return this.id; }

    public User getRecipient() { return this.recipient; }

    public User getSender() { return this.sender; }

    public TransferCategory getTransferCategory() { return this.transferCategory; }

    public int getTransferAmount() { return this.transferAmount; }

    public Transaction getNext() { return this.next; }

    public Transaction getPrev() { return this.prev; }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setTransferCategory(TransferCategory transferCategory) {
        this.transferCategory = transferCategory;
    }

    public void setTransferAmount(int transferAmount) {
        this.transferAmount = transferAmount;
    }

    public void setNext(Transaction next) {
        this.next = next;
    }

    public void setPrev(Transaction prev) {
        this.prev = prev;
    }

    public boolean checkTransfer() {
        if (transferCategory == TransferCategory.debit) {
            if (recipient.getBalance() + transferAmount <= 0 || transferAmount == 0) {
                System.out.println("Error: Transaction wasn't completed because the amount isn't correct");
                return false;
            }
        }
        else if (transferCategory == TransferCategory.credit) {
            if (sender.getBalance() - transferAmount <= 0) {
                System.out.println("Error: Transaction wasn't completed because the sender didn't have enough money");
                return false;
            }
            else if (transferAmount == 0) {
                System.out.println("Error: Transaction wasn't completed because the amount isn't correct");
                return false;
            }
        }
        return true;
    }
}