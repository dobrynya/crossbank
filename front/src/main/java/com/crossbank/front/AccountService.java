package com.crossbank.front;

import com.crossbank.model.AccountPage;

/**
 * Provides information on accounts as a sequence of pages.
 * @uathor Dmitry Dobrynin
 * Created at 07.02.16 0:34.
 */
public interface AccountService {
    AccountPage accountInfos(int start);
}
