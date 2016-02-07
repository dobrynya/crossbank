package com.crossbank.front;

import com.crossbank.model.AccountInfo;
import com.crossbank.model.AccountPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.*;

/**
 * Requests the account service for account infos.
 * @author Dmitry Dobrynin
 * Created at 07.02.16 0:49.
 */
@Component("accountService")
public class AccountServiceImpl implements AccountService {
    @Value("${account.service.url}")
    private String url;
    @Autowired
    private RestTemplate client;

    public AccountPage accountInfos(final int start) {
        return client.getForObject("{url}?start={start}", AccountPage.class,
                new HashMap<String, Object>() {{
                    put("url", url);
                    put("start", start);
                }});
    }

    public Iterator<AccountInfo> accountInfos() {
        return new Iterator<AccountInfo>() {
            AccountPage page = new AccountPage(Collections.<AccountInfo>emptyList(), true, 0);
            Iterator<AccountInfo> infos = Collections.emptyIterator();

            private void load() {
                page = accountInfos(page.getNextPageStart());
                infos = page.getAccountInfos().iterator();
            }

            public boolean hasNext() {
                boolean hasNext = infos.hasNext();
                if (!hasNext && page.getHasNext()) {
                    load();
                    return hasNext();
                }
                return hasNext;
            }

            public AccountInfo next() {
                return infos.next();
            }
        };
    }
}
