package com.by;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author zhouboyang
 * @Date 2021/1/7 16:06
 * @Version 1.0
 */
public class TestTime {
    public static void main(String[] args) {
        System.out.println("BUI_USER_REGISTER_APPLY_DEFAULT".startsWith("BUI_USER_REGISTER_APPLY"));
        test3();
    }

    public static void test(){
        double a = 421/1000.0;
        System.out.println(a);
        double f = 1233.5585;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(f));
    }

    public static void test1(){
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    public static void test2(){
        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Timestamp time = Timestamp.valueOf(LocalDateTime.now());
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        Timestamp timestamp1 = new Timestamp(new Date(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).getTime());
        System.out.println(timestamp1);
        System.out.println(time);
    }

    public static void test3(){
        DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int monthValue = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();
        System.out.println(now);
        System.out.println(LocalDateTime.now().format(DATETIME_FORMATTER));
        System.out.printf("year = %d, month = %d, day = %d", year, monthValue, dayOfMonth);
    }
}
