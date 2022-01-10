package com.linkedin.learning.learningspring.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DateUtils {
    
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    public static Date getDateFromString(String dateString) {
        Date date = null;
        
        if (Objects.isNull(dateString)) {
            date = new Date();
        } else {
            try {
                date = DATE_FORMAT.parse(dateString);
            }
            catch (ParseException e) {
                date = new Date();
            }
        }
        
        return date;
    }
}
