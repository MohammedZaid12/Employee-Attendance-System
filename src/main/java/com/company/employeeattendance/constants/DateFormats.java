package com.company.employeeattendance.constants;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class DateFormats {

    private static final String FORMAT_1 = "dd-MMMM-yyyy";
    private static final String FORMAT_2 = "yyyy-MM";
    private static final String FORMAT_3 = "yyyy-MM-dd";
    private static final String FORMAT_4 = "MMMM-yyyy";
    private static final String FORMAT_5 = "MMM-yy";
    private static final String FORMAT_6 = "dd-MM-yyyy";
    private static final String FORMAT_7 = "dd-MM-yyyy HH:mm:ss";
    private static final String FORMAT_8 = "dd-MM-yyyy";

    private static final String TIME_FORMAT_1 = "HH:mm";
    private static final String TIME_FORMAT_2 = "HH:mm:ss";

    public static final DateTimeFormatter dd_MMMM_yyyy = DateTimeFormatter.ofPattern(FORMAT_1);
    public static final DateTimeFormatter dd_MMMM_yyyy_HH_mm_ss = DateTimeFormatter.ofPattern(FORMAT_7);
    public static final DateTimeFormatter dd_MM_yyyy_dateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT_8);
    public static final DateTimeFormatter yyyy_MM = DateTimeFormatter.ofPattern(FORMAT_2);
    public static final DateTimeFormatter YYYY_MM_dd = DateTimeFormatter.ofPattern(FORMAT_3);
    public static final DateTimeFormatter MMMM_YYYY = DateTimeFormatter.ofPattern(FORMAT_4);
    public static final DateTimeFormatter MMM_YY = DateTimeFormatter.ofPattern(FORMAT_5);

    public static final DateTimeFormatter HH_mm = DateTimeFormatter.ofPattern(TIME_FORMAT_1);
    public static final DateTimeFormatter HH_mm_ss = DateTimeFormatter.ofPattern(TIME_FORMAT_2);

    public static final SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat(FORMAT_3);
    public static final SimpleDateFormat dd_yyyy_MM = new SimpleDateFormat(FORMAT_1);
    public static final SimpleDateFormat dd_MM_yyyy = new SimpleDateFormat(FORMAT_6);


}

