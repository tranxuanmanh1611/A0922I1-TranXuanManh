package models;

public class Contract {
    private String contractNumber;
    private String bookingCode;
    private int deposit;
    private int totalPaid;
    private String customerId;

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(int totalPaid) {
        this.totalPaid = totalPaid;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Contract() {
    }

    public Contract(String contractNumber, String bookingCode, int deposit, int totalPaid, String customerId) {
        setContractNumber(contractNumber);
        setBookingCode(bookingCode);
        setDeposit(deposit);
        setTotalPaid(totalPaid);
        setCustomerId(customerId);
    }
}
