package com.specialist1.lab1.ex2;

public class Main {

    public static void main(String[] args) {

        int year = 1999;
        int dayNum = 327;
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] months = {"Jan", "Feb", "March", "Apr", "May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        int monthNum = 0;
        boolean isLeapYear;

        isLeapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

        for(int days : daysInMonths){
            if(isLeapYear && days == 28) days++;

            if(dayNum <= days) break;
            dayNum -= days;
            monthNum++;
        }

        System.out.println(months[monthNum] + " " + dayNum);

    }
}
