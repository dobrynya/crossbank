package com.crossbank.front;

import com.crossbank.model.AccountInfo;
import com.crossbank.model.AccountPage;

import java.util.Iterator;

/**
 * Provides information on accounts as a sequence of pages.
 * @author Dmitry Dobrynin
 * Created at 07.02.16 0:34.
 */
public interface AccountService {
    AccountPage accountInfos(int start);

    Iterator<AccountInfo> accountInfos();
}
