package com.capston_design.fkiller.itoms.ticket_core.common.util;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class ClockUtils {

    public static LocalDateTime parseToLocalDateTime(String clockHolderTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return OffsetDateTime.parse(clockHolderTime, formatter).toLocalDateTime();
    }
}
