package com.crossbank.front;

import com.crossbank.model.AccountPage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;

/**
 * Requests the account service for account infos.
 * @uathor Dmitry Dobrynin
 * Created at 07.02.16 0:49.
 */
@Component("accountService")
public class AccountServiceImpl implements AccountService {
    @Value("${account.service.url}/accounts")
    private String accountServiceUrl;

    public AccountPage accountInfos(final int start) {
        return new RestTemplate().getForObject("${url}/${staring}", AccountPage.class,
                new HashMap<String, Object>() {{
                    put("url", accountServiceUrl);
                    put("starting", start);
                }});
    }
}
