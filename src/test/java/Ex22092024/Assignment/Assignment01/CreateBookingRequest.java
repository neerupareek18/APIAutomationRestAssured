package Ex22092024.Assignment.Assignment01;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.testng.annotations.Test;

public class CreateBookingRequest {

    public String bookingRequest() {
        BookingPojo bp = new BookingPojo();
        BookingDatesPojo bdp = new BookingDatesPojo();

        Faker f = new Faker();
        bp.setFirstname(f.name().firstName());
        bp.setLastname(f.name().lastName());
        bp.setTotalprice(Integer.valueOf(f.number().digits(3)));
        bp.setDepositepaid(true);
        bp.setAdditionalneeds(f.food().ingredient());


       bdp.setCheckoutdate("2024-10-01");
       bdp.setCheckindate("2024-09-28");

       bp.setBookingdates(bdp);

       Gson g = new Gson();
       String payload = g.toJson(bp);
        System.out.println(payload);

        return payload;
    }

}
