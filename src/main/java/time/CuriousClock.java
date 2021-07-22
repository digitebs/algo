package time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Benjamin recently bought a digital clock at a magic trick shop. The seller never told Ben what was
 * so special about it, but mentioned that one day Benjamin would be faced with a surprise.
 *
 * Indeed, the clock did surprise Benjamin: without warning, at someTime the clock suddenly
 * started going in the opposite direction! Unfortunately, Benjamin has an important meeting very
 * soon, and knows that at leavingTime he should leave the house so as to not be late. Ben spent all
 * his money on the clock, so has to figure out what time his clock will show when it's time to
 * leave.
 *
 * Given the someTime at which the clock started to go backwards, find out what time will be
 * shown on the curious clock at leavingTime
 *
 *
 * easy*
 *
 * your broken clock start time.
 * start time counter clockwise. leave time is the time your suppose to leave office. find the time of the clock.
 *
 * @author john.lim
 */
public class CuriousClock {
    String curiousClock(String s, String l) throws Exception {
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return f.format(new Date(2*f.parse(s).getTime() -f.parse(l).getTime()));
    }

  public static void main(String[] args) {
    //
      CuriousClock cc = new CuriousClock();
      try{
      System.out.println(cc.curiousClock("2016-08-26 22:40","2016-08-29 10:00"));
      }catch (Exception e){}
  }
}
