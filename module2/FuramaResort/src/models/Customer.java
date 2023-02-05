package models;

public class Customer extends Person {
    private int customerId;
    private String membership;
    private String address;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        if (membership.equals("Diamond") || membership.equals("Platinum") || membership.equals("Gold")
                || membership.equals("Silver") || membership.equals("Member")) {
            this.membership = membership;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer() {    }

    public Customer(int customerId,String name, String birthday, String gender, String citizenId, String phoneNumber, String email, String membership, String address) {
        super(name, birthday, gender, citizenId, phoneNumber, email);
        setCustomerId(customerId);
        setMembership(membership);
        setAddress(address);

    }
}
