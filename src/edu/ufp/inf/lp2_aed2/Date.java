package edu.ufp.inf.lp2_aed2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date> {

    private int day;

    private int month;

    private int year;

    private int hour;

    private int minute;

    private int second;

    private int milisecond;

    private int dayOfWeek;

    public Date(int day, int month, int year, int hour, int minute, int second) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Date(int day, int month, int year, int hour, int minute, int second, int dayOfWeek) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.dayOfWeek = dayOfWeek;
    }

    public Date(int day, int month, int year, int hour, int minute, int second, int milisecond, int dayOfWeek) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.milisecond = milisecond;
        this.dayOfWeek = dayOfWeek;
    }

    public Date() {
        GregorianCalendar gregCalendar = new GregorianCalendar();
        this.day = gregCalendar.get(Calendar.DAY_OF_MONTH);
        this.month = gregCalendar.get(Calendar.MONTH) + 1;
        this.year = gregCalendar.get(Calendar.YEAR);
        this.hour = gregCalendar.get(Calendar.HOUR_OF_DAY);
        this.minute = gregCalendar.get(Calendar.MINUTE);
        this.second = gregCalendar.get(Calendar.SECOND);
        this.milisecond = gregCalendar.get(Calendar.MILLISECOND);
        this.dayOfWeek = gregCalendar.get(Calendar.DAY_OF_WEEK);
    }

    public int compareTo(Date d) {
        if (this.dayOfWeek == d.dayOfWeek && this.year == d.year && this.month == d.month && this.day == d.day && this.hour == d.hour && this.minute == d.minute && this.second == d.second && this.milisecond == d.milisecond) {
            return 0;
        } else if (this.year == d.year) {
            if (this.month == d.month) {
                if(this.dayOfWeek == d.dayOfWeek){
                    if (this.day == d.day) {
                        if (this.hour == d.hour) {
                            if (this.minute == d.minute) {
                                if (this.second == d.second) {
                                    return this.milisecond < d.milisecond ? -1 : 1;
                                }
                                return this.second < d.second ? -1 : 1;
                            }

                            return this.minute < d.minute ? -1 : 1;
                        }
                        return this.hour < d.hour ? -1 : 1;
                    }
                    return this.day < d.day ? -1 : 1;
                }
                return this.dayOfWeek < d.dayOfWeek ? -1 : 1;
            } else {
                return this.month < d.month ? -1 : 1;
            }
        } else {
            return this.year < d.year ? -1 : 1;
        }
    }


    @Override
    public String toString() {
        return this.getDayOfWeek() + " " + this.day + "/" + this.month + "/" + this.year + " " + this.hour + ":" + this.minute + ":" + this.second + "." + this.milisecond;
    }

    public String getDayOfWeek()
    {
        String dayOfTheWeek = null;

        if(dayOfWeek == 2){
            dayOfTheWeek = "Mon";
        } else if (dayOfWeek == 3){
            dayOfTheWeek = "Tue";
        } else if (dayOfWeek == 4){
            dayOfTheWeek = "Wed";
        } else if (dayOfWeek == 5){
            dayOfTheWeek = "Thu";
        } else if (dayOfWeek == 6){
            dayOfTheWeek = "Fri";
        } else if (dayOfWeek == 7){
            dayOfTheWeek = "Sat";
        } else if (dayOfWeek == 1){
            dayOfTheWeek = "Sun";
        }
        
        return dayOfTheWeek;
    }

    public void setDayOfWeek(int dayOfWeek){ this.dayOfWeek = dayOfWeek;}

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMilisecond() {
        return milisecond;
    }

    public void setMilisecond(int milisecond) {
        this.milisecond = milisecond;
    }
}