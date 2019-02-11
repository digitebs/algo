import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by johnlim on 18/10/16.
 */
public class Time {
    public static void main(String args[]){

        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("PST"));
        String r =sdf.format(d);
        try {
            sdf.setTimeZone(TimeZone.getDefault());
            Date d2= sdf.parse(r);
            System.out.println(d2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
