package input;

public class ATM extends Card{

    public ATM(){}

    public ATM(String cardNumber, String cardOwner, String ownerCitizenID, String ownerAddress,int balance,String type) {
       super(cardNumber,cardOwner,ownerCitizenID,ownerAddress,type,balance);
    }

    @Override
    public void deposit(int money) {
        super.deposit(money);
    }

    @Override
    public void withdraw(int money) {
        super.withdraw(money);
    }

    @Override
    public String toFileString() {
        return super.toFileString();
    }

    @Override
    public String toString() {
        return "ATM{"+super.toString() +
                "} " ;
    }
}
