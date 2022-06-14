package com.company.employeeattendance.utils;

import java.sql.Date;
import java.text.DateFormatSymbols;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DateUtils {

    public static List<String> getDaysOfWeek() {
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] weekdays = dfs.getWeekdays();
        return Arrays.asList(weekdays).stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
    }

    public static List<String> getMonths() {
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] month = dfs.getMonths();
        return Arrays.asList(month).stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
    }

    public static List<Integer> getYearListFromYear(Integer year) {
        List<Integer> yearList = new ArrayList<>();
        for (int i = year - 1; i <= year + 5; i++) {
            yearList.add(i);
        }
        return yearList;
    }

    public static Period getDifferenceBetweenTwoDates(Date startDate, Date endDate) {
        return Period.between(startDate.toLocalDate(), endDate.toLocalDate());
    }
}
