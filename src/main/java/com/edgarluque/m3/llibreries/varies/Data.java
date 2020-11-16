package com.edgarluque.m3.llibreries.varies;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Data {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public static String imprimirData(LocalDateTime localDateTime) {
        if(localDateTime == null)
            return "NULL";
        return FORMATTER.format(localDateTime);
    }
}
