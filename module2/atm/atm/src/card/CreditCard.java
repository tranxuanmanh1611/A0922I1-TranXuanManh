package card;

public class CreditCard extends Card{
       private int limit;

    public CreditCard(){}
    public CreditCard(String cardNumber, String cardOwner, String ownerCitizenID, String ownerAddress,int balance, int limit,String type) {
        super(cardNumber,cardOwner,ownerCitizenID,ownerAddress,type,balance);
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String toFileString() {
        return super.toFileString()+ ","+limit;
    }

    @Override
    public String toString() {
        return "CreditCard{"+ super.toString() +
                "limit=" + limit +
                "} " ;
    }

}
