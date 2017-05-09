package com.bitreight.profitprint.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.Data;

import java.time.LocalTime;

/**
 * @author bitreight
 */
@Data
public class Executor {

    @JsonProperty(access = Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = Access.WRITE_ONLY)
    private String login;

    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    private String phone;

    private String email;

    private String address;

    @JsonFormat(pattern = "HH:mm")
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonSerialize(using = LocalTimeSerializer.class)
    private LocalTime openTime;

    @JsonFormat(pattern = "HH:mm")
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonSerialize(using = LocalTimeSerializer.class)
    private LocalTime closeTime;

    private String webSite;

    @JsonProperty(access = Access.WRITE_ONLY)
    private String regKey;
}
