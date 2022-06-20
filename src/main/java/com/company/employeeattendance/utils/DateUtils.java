package com.company.employeeattendance.utils;

import org.apache.tomcat.jni.Local;

import java.sql.Date;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static Integer getDifferenceBetweenTwoTime(LocalTime startTime, LocalTime endTime) {
        Long time = startTime.until(endTime, ChronoUnit.HOURS);
        return time.intValue() > 0 ? time.intValue() : 0;
    }
    public static List<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            return new ArrayList<>();
        } else {
            return Stream.iterate(startDate, date -> date.plusDays(1)).limit(ChronoUnit.DAYS.between(startDate, endDate.plusDays(1))).collect(Collectors.toList());
        }

    }

}
