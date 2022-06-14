package com.company.employeeattendance.utils;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DateUtils {

    public static List<String> getDaysOfWeek() {
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] weekdays = dfs.getWeekdays();
        return Arrays.asList(weekdays).stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
    }
}
