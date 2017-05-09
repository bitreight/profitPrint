package com.bitreight.profitprint.service.mapper;

import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalTime;

/**
 * @author bitreight
 */
@Component
public class LocalTimeToTimeMapper {

    public Time map(LocalTime value) {
        return Time.valueOf(value);
    }
}
