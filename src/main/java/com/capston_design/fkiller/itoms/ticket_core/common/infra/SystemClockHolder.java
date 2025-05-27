package com.capston_design.fkiller.itoms.ticket_core.common.infra;

import com.capston_design.fkiller.itoms.ticket_core.common.service.ClockHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class SystemClockHolder implements ClockHolder {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS+09:00");

    @Override
    public String now() {
        LocalDateTime nowTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = nowTime.atZone(ZoneOffset.UTC);
        return FORMATTER.format(zonedDateTime);
    }
}
