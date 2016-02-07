package com.crossbank.transactions;

import com.crossbank.model.FinancialPosition;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

/**
 * Provides financial position data.
 * @author Dmitry Dobrynin <dobrynya@inbox.ru>
 *         Created at 08.02.2016 0:13
 */
@Component
public class FinancialPositionService {
    private Map<Integer, FinancialPosition> positions = new HashMap<Integer, FinancialPosition>() {{
        put(2013, new FinancialPosition("2013",
                "6,223", "12,06", "17,48", "1,318", "58,348", "4,187", "2,355", "1,577", "22,725", "16,625", "350"));
        put(2014, new FinancialPosition("2014",
                "5,223", "17,787", "13,198", "1,318", "58,348", "4,187", "2,355", "1,577", "22,725", "16,625", "350"));
        put(2015, new FinancialPosition("2015",
                "7,223", "11,766", "13,198", "1,318", "58,348", "4,187", "2,355", "1,577", "22,725", "16,625", "350"));
    }};


    public FinancialPosition getFinancialPosition(int year) {
        FinancialPosition position = positions.get(year);
        if (position == null)
            throw new IllegalArgumentException("No data for specified year: " + year + "!");
        return position;
    }
}
