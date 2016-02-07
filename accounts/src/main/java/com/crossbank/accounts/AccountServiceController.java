package com.crossbank.accounts;

import com.crossbank.model.AccountPage;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Publishes account service as a rest web service.
 * @author Dmitry Dobrynin <dobrynya@inbox.ru>
 *         Created at 07.02.2016 12:59
 */
@RestController
public class AccountServiceController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/accounts")
    public AccountPage getAccounts(@RequestParam(name = "start", defaultValue = "0") int start) {
        return accountService.getAccounts(start);
    }
}
