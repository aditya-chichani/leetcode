package com.company.miscellanous;

import java.util.HashMap;

public class Solution {
    static HashMap<String, String> dayMap = new HashMap<>();
    static HashMap<String, String> monthMap = new HashMap<>();

    static {
        dayMap.put("1st", "01");
        dayMap.put("2nd", "02");
        dayMap.put("3rd", "03");
        dayMap.put("4th", "04");
        dayMap.put("5th", "05");
        dayMap.put("6th", "06");
        dayMap.put("7th", "07");
        dayMap.put("8th", "08");
        dayMap.put("9th", "09");
        dayMap.put("10th", "10");
        dayMap.put("11th", "11");
        dayMap.put("12th", "12");
        dayMap.put("13th", "13");
        dayMap.put("14th", "14");
        dayMap.put("15th", "15");
        dayMap.put("16th", "16");
        dayMap.put("17th", "17");
        dayMap.put("18th", "18");
        dayMap.put("19th", "19");
        dayMap.put("20th", "20");
        dayMap.put("21st", "21");
        dayMap.put("22nd", "22");
        dayMap.put("23rd", "23");
        dayMap.put("24th", "24");
        dayMap.put("25th", "25");
        dayMap.put("26th", "26");
        dayMap.put("27th", "27");
        dayMap.put("28th", "28");
        dayMap.put("29th", "29");
        dayMap.put("30th", "30");
        dayMap.put("31st", "31");

        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");

    }

    public String reformatDate(String date) {
        // "20th Oct 2052" "2052-10-20" YYYY-MM-DD
        String[] split = date.split(" ");
        return split[2] + "-" + monthMap.get(split[1]) + "-" + dayMap.get(split[0]);
    }
}
