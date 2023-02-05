package models;

public class Booking {
    private String bookingCode;
    private int checkIn;
    private int checkOut;
    private int customerId;
    private String rentType;

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public int getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(int checkIn) {
        this.checkIn = checkIn;
    }

    public int getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(int checkOut) {
        this.checkOut = checkOut;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getRentType() {
        return rentType;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public Booking() {
        }

    public Booking(String bookingCode, int checkIn, int checkOut, int customerId, String rentType) {
        setBookingCode(bookingCode);
        setCheckIn(checkIn);
        setCheckOut(checkOut);
        setCustomerId(customerId);
        setRentType(rentType);
    }
}
