package time;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Calendar {
    public static void main(String[] args) {
        DayOfWeek.from(LocalDate.of(2020,1,1)).name();

       java.util.Calendar c = java.util.Calendar.getInstance();
       c.set(2020,1,1);
       c.get(java.util.Calendar.DAY_OF_WEEK);

    }
}
