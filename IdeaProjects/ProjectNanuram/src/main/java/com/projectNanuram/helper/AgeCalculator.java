package com.projectNanuram.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AgeCalculator {

    public static int age(String birthday) throws ParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birth = LocalDate.parse(birthday , formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birth , currentDate);

        return period.getYears();
    }
}
