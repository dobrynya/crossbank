package com.crossbank.accounts;

import com.crossbank.model.Account;
import com.crossbank.model.AccountInfo;
import com.crossbank.model.AccountPage;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static java.util.Arrays.asList;

/**
 * Provides account related information. This Account service may not expose the same interface as a consume use. This makes micro-services loosely coupled.
 * @author Dmitry Dobrynin
 * Created at 07.02.16 0:58.
 */
@Component
public class AccountService {
    private int pageSize = 10;

    List<AccountInfo> infos = asList(
            new AccountInfo(new Account("Archibald Stanton"), BigDecimal.TEN, new Date()),
            new AccountInfo(new Account("Froddo Baggins"), BigDecimal.ONE, new Date()),
            new AccountInfo(new Account("Freddie Mercury"), BigDecimal.valueOf(500), new Date()),
            new AccountInfo(new Account("Soulietta Minier"), BigDecimal.valueOf(1000), new Date()),
            new AccountInfo(new Account("Sharph Overnight"), BigDecimal.ONE, new Date()),
            new AccountInfo(new Account("Dmitry Spivakov"), BigDecimal.ONE, new Date()),
            new AccountInfo(new Account("Sauron"), BigDecimal.valueOf(150), new Date()),
            new AccountInfo(new Account("Gandalf The Grey"), BigDecimal.TEN, new Date()),
            new AccountInfo(new Account("Martin Odersky"), BigDecimal.TEN, new Date()),
            new AccountInfo(new Account("Born Austerlic"), BigDecimal.ONE, new Date()),
            new AccountInfo(new Account("Melany Dynya"), BigDecimal.ONE, new Date()),
            new AccountInfo(new Account("Roger Taylor"), BigDecimal.ONE, new Date()),
            new AccountInfo(new Account("Brian May"), BigDecimal.ONE, new Date()),
            new AccountInfo(new Account("Dmitry Dobrynin"), BigDecimal.ONE, new Date()),
            new AccountInfo(new Account("Mustapha Ibragim"), BigDecimal.ONE, new Date()),
            new AccountInfo(new Account("John Deacon"), BigDecimal.ONE, new Date()),
            new AccountInfo(new Account("James Hatfield"), BigDecimal.ONE, new Date()),
            new AccountInfo(new Account("Kirk Hammet"), BigDecimal.ONE, new Date()),
            new AccountInfo(new Account("Lars Ulrich"), BigDecimal.ONE, new Date()),
            new AccountInfo(new Account("Robert Trujillo"), BigDecimal.ONE, new Date()),
            new AccountInfo(new Account("Cliff Burton"), BigDecimal.ONE, new Date())
    );

    AccountPage getAccounts(int start) {
        List<AccountInfo> res = new ArrayList<>();
        boolean hasNext = false;
        if (start <= infos.size()) {
            hasNext = infos.size() > start + pageSize;
            res.addAll(infos.subList(start, hasNext ? start + pageSize : infos.size()));
        }
        return new AccountPage(res, hasNext, hasNext ? start + pageSize : 0);
    }
}
