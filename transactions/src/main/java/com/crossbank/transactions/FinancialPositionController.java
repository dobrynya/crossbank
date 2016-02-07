package com.crossbank.transactions;

import com.crossbank.model.FinancialPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Publishes a service.
 * @author Dmitry Dobrynin <dobrynya@inbox.ru>
 *         Created at 08.02.2016 0:53
 */
@RestController
public class FinancialPositionController {
    @Autowired
    private FinancialPositionService financialPositionService;

    @RequestMapping("/financialPosition")
    public FinancialPosition getFinancialPosition(@RequestParam("year") int year) {
        return financialPositionService.getFinancialPosition(year);
    }
}
