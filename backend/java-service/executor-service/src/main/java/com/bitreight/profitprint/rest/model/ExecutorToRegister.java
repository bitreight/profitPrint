package com.bitreight.profitprint.rest.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author bitreight
 */
@Data
public class ExecutorToRegister {

    @NotNull @Size(min = 4, max = 10)
    private String login;
    @NotNull @Size(min = 6, max = 16)
    private String password;
    @NotNull
    private String phone;
    @NotNull
    private String email;
    @NotNull
    private String address;
    @NotNull
    private String openTime;
    @NotNull
    private String closeTime;
    private String webSite;
    @NotNull
    private String regKey;
}
