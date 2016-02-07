package com.crossbank.accounts;

import com.crossbank.model.Account;
import com.crossbank.model.AccountInfo;
import com.crossbank.model.AccountPage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Provides account related information.
 * @uathor Dmitry Dobrynin
 * Created at 07.02.16 0:58.
 */
public class AccountService {

    private int page

    List<AccountInfo> infos = asList(
            new AccountInfo(new Account("Archibald Stanton"), BigDecimal.TEN, new Date()),
            new AccountInfo(new Account("Froddo Baggins"), BigDecimal.ONE, new Date()),
            new AccountInfo(new Account("Freddie Mercury"), BigDecimal.valueOf(500), new Date()),
            new AccountInfo(new Account("Soulietta Minier"), BigDecimal.valueOf(1000), new Date()),
            new AccountInfo(new Account("Sharph Overnoght"), BigDecimal.ONE, new Date())
    );

    AccountPage getAccounts(int start) {
        List<AccountInfo> res = new ArrayList<AccountInfo>();
        boolean hasNext = true;
        if (start <= infos.size()) {
            infos.subList()
        }
    }
}
