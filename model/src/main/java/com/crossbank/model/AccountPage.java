package com.crossbank.model;

import java.util.List;

/**
 * Represents a page of account info instances and info on next page presence.
 * @author Dmitry Dobrynin
 * Created at 07.02.16 0:44.
 */
public class AccountPage {
    private List<AccountInfo> accountInfos;
    private boolean hasNext;
    private int nextPageStart;

    public AccountPage() {}

    public AccountPage(List<AccountInfo> accountInfos, boolean hasNext, int nextPageStart) {
        this.accountInfos = accountInfos;
        this.hasNext = hasNext;
        this.nextPageStart = nextPageStart;
    }

    public List<AccountInfo> getAccountInfos() {
        return accountInfos;
    }

    public boolean getHasNext() {
        return hasNext;
    }

    public int getNextPageStart() {
        return nextPageStart;
    }
}
