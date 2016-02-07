package com.crossbank.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents information on an account.
 * @author Dmitry Dobrynin
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

    public Account getAccount() {
        return account;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public String toString() {
        return "AccountInfo{" +
                "account=" + account +
                ", balance=" + balance +
                ", lastActivity=" + lastActivity +
                '}';
    }
}
