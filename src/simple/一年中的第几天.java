package simple;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

;

/**
 * @Author wrobby
 * @Date 2021/12/24 19:10
 * @Version 1.0
 */
public class 一年中的第几天 {


    public static int dayOfYear(String date) {
        LocalDate localDate = LocalDate.parse(date);
       Calendar calendar=Calendar.getInstance(Locale.CHINA);
        return localDate.getDayOfYear();
    }

    public static void main(String[] args) {
        System.out.println(dayOfYear("2004-03-01"));
    }
}
