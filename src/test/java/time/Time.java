package time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/** Created by johnlim on 18/10/16. */
public class Time {
  boolean validTime(String time){
    try{ LocalTime.parse(time); }catch(Exception e){ return  false; }
    return true;
  }

  boolean validTime2(String time){
    try{ DateFormat.getTimeInstance().parse(time); }catch(Exception e){ return  false; }
    return true;
  }
  public static void main(String args[]) {

    System.out.println(new Time().validTime2("25:51"));
    Date d = new Date();
    System.out.println(d);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    sdf.setTimeZone(TimeZone.getTimeZone("PST"));
    String r = sdf.format(d);
    try {
      sdf.setTimeZone(TimeZone.getDefault());
      Date d2 = sdf.parse(r);
      System.out.println(d2);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
