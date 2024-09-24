package Ex22092024.Assignment.Assignment01;

public class ResponsePojo {
    String bookingid;

    public CreateBookingRequest getBooking() {
        return booking;
    }

    public void setBooking(CreateBookingRequest booking) {
        this.booking = booking;
    }

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    CreateBookingRequest booking;


}
