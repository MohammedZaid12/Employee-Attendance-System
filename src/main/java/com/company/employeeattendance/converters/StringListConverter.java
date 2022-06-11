package com.company.employeeattendance.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

    private static final String SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(List<String> datesList) {

        if (datesList == null)
            return null;

        if (datesList.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String date : datesList) {
            sb.append(date).append(SEPARATOR);
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    @Override
    public List<String> convertToEntityAttribute(String datesCommaSeparated) {
        if (datesCommaSeparated == null) {
            return new ArrayList<>();
        }
        String[] stringDates = datesCommaSeparated.split(SEPARATOR);
        return new ArrayList<>(Arrays.asList(stringDates));
    }
}
