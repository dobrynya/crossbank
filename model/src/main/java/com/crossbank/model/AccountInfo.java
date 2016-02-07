package com.crossbank.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents information on an account.
 * @uathor Dmitry Dobrynin
 * Created at 07.02.16 0:27.
 */
public class AccountInfo {
    private Account account;
    private BigDecimal balance;
    private Date lastActivity;

    public AccountInfo() {}

    public AccountInfo(Account account, BigDecimal balance, Date lastActivity) {
        this.account = account;
        this.balance = balance;
        this.lastActivity = lastActivity;
    }
}
