package com.crossbank.model;

import java.util.List;

/**
 * Represents a page of account info instances.
 * @uathor Dmitry Dobrynin
 * Created at 07.02.16 0:44.
 */
public class AccountPage {
    private List<AccountInfo> accountInfos;
    private boolean hasNext;

    public AccountPage() {}

    public AccountPage(List<AccountInfo> accountInfos, boolean hasNext) {
        this.accountInfos = accountInfos;
        this.hasNext = hasNext;
    }

    public List<AccountInfo> getAccountInfos() {
        return accountInfos;
    }

    public boolean isHasNext() {
        return hasNext;
    }
}
