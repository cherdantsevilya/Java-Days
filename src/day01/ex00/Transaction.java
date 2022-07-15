package day01.ex00;

import java.util.UUID;

enum TransferCategory {
    DEBIT,
    CREDIT
}

public class Transaction {

    private UUID id;
    private User recipient;
    private User sender;
    private TransferCategory transferCategory;
    private Integer transferAmount;
    private Boolean correctOperation;

    public Transaction(UUID id, User recipient, User sender, TransferCategory transferCategory, Integer transferAmount) {
        this.id = id;
        this.recipient = recipient;
        this.sender = sender;
        this.transferCategory = transferCategory;
        if (transferAmount == null || transferAmount <= 0)
            this.transferAmount = 0;
        else
            this.transferAmount = transferAmount;
        this.correctOperation = false;
        if (!checkTransfer())
            return ;
        sender.setBalance(sender.getBalance() - transferAmount);
        recipient.setBalance(recipient.getBalance() + transferAmount);
    }

    public UUID getId() { return this.id; }

    public User getRecipient() { return this.recipient; }

    public User getSender() { return this.sender; }

    public TransferCategory getTransferCategory() { return this.transferCategory; }

    public Integer getTransferAmount() { return this.transferAmount; }

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

    public void setTransferAmount(Integer transferAmount) {
        if (transferAmount == null || transferAmount <= 0)
            this.transferAmount = 0;
        else
            this.transferAmount = transferAmount;
    }

    public boolean checkTransfer() {
        if (transferAmount == 0) {
            System.out.println("Error: Transaction wasn't completed because the amount isn't correct");
            return false;
        } else if (sender.getBalance() - transferAmount < 0) {
            System.out.println("Error: Transaction wasn't completed because the sender didn't have enough money");
            return false;
        } else
            this.correctOperation = true;
            return true;
    }

    @Override
    public String toString() {
        if (this.correctOperation) {
            if (this.transferCategory == TransferCategory.DEBIT) {
                return recipient.getName() + " -> " + sender.getName() + ", +" + transferAmount + ", INCOME, transaction " + getId();
            } else {
                return sender.getName() + " -> " + recipient.getName() + ", -" + transferAmount + ", OUTCOME, transaction " + getId();
            }
        } else {
            return "Incorrect operation";
        }
    }
}
