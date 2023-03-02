package input;

import java.io.Serializable;

public abstract class Card implements Serializable {
    private String type;
    private String cardNumber;
    private String cardOwner;
    private String ownerCitizenID;
    private String ownerAddress;
    private int balance;

    public Card() {
    }

    public Card(String cardNumber, String cardOwner, String ownerCitizenID, String ownerAddress, String type, int balance) {
        this.cardNumber = cardNumber;
        this.cardOwner = cardOwner;
        this.ownerCitizenID = ownerCitizenID;
        this.ownerAddress = ownerAddress;
        this.type = type;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner;
    }

    public String getOwnerCitizenID() {
        return ownerCitizenID;
    }

    public void setOwnerCitizenID(String ownerCitizenID) {
        this.ownerCitizenID = ownerCitizenID;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int money) {
        this.balance += money;
    }

    public void withdraw(int money) {
        balance = balance-  money;
    }

    public String toFileString() {
        return type + "," + cardNumber + ',' + cardOwner + ',' + ownerCitizenID + ',' + ownerAddress + ',' + balance;
    }

    @Override
    public String toString() {
        return "cardNumber='" + cardNumber + '\'' +
                ", cardOwner='" + cardOwner + '\'' +
                ", ownerCitizenID='" + ownerCitizenID + '\'' +
                ", ownerAddress='" + ownerAddress + '\'' +
                ", balance='" + balance + '\'';
    }
}
