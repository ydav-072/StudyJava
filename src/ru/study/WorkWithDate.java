package ru.study;

import org.w3c.dom.ls.LSOutput;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class WorkWithDate {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, 1);//add 1 week to now date
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);//format date with preset
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");//format date with creat rules
        try {
            Date dateParseFromString = simpleDateFormat.parse("29.12.2005 00:57:03");//parse date from String
            System.out.println(dateParseFromString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(simpleDateFormat.format(calendar.getTime()));
        System.out.println(dateFormat.format(calendar.getTime()));
        System.out.println(calendar.getTime());
        System.out.println(calendar);
        System.out.println(date);
    }


}
