package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste {
    public static void main(String args[]) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date checkin = sdf.parse("23/09/2019");
        Date checkout = sdf.parse("26/09/2019");

       // System.out.println(checkout.getTime());
        //System.out.println(checkin.getTime());
        //System.out.println(checkout.getTime() - checkin.getTime());
        //int days = (int) (checkout.getTime() - checkin-getTime() / 100);
        System.out.println(duration(checkin, checkout));

        
    }

    public static Integer duration(Date checkin, Date checkout){
        long diff = checkout.getTime() - checkin.getTime();
        int days = (int) (diff / (1000*60*60*24));
        return days;
    }
}
