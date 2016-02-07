package com.crossbank.front;

import com.crossbank.model.FinancialPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;

/**
 * Provides financial position data.
 * @author Dmitry Dobrynin <dobrynya@inbox.ru>
 *         Created at 08.02.2016 0:28
 */
@Component
public class FinancialPositionService {
    @Autowired
    private RestTemplate client;
    @Value("${transaction.service.url}")
    private String url;

    public FinancialPosition getFinancialPosition(final int year) {
        return client.getForObject("{url}?year={year}", FinancialPosition.class, new HashMap<String, Object>() {{
            put("url", url);
            put("year", year);
        }});
    }
}
