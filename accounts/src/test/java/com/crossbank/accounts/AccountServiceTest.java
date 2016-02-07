package com.crossbank.accounts;

import org.junit.Test;
import static org.junit.Assert.*;
import com.crossbank.model.AccountPage;

/**
 * Tests AccountService.
 * @author Dmitry Dobrynin <dobrynya@inbox.ru>
 *         Created at 07.02.2016 12:50
 */
public class AccountServiceTest {
    AccountService as = new AccountService();

    @Test
    public void accountServiceReturnsAPageOfFixedSize() throws Exception {
        AccountPage res = as.getAccounts(0);
        assertTrue(res.getHasNext());
        assertEquals(10, res.getNextPageStart());
        assertEquals(10, res.getAccountInfos().size());
    }

    @Test
    public void accountServiceReturnEmptyPageIfNoElements() {
        AccountPage res = as.getAccounts(1000);
        assertFalse(res.getHasNext());
        assertEquals(0, res.getNextPageStart());
        assertTrue(res.getAccountInfos().isEmpty());
    }

    @Test
    public void accountServiceReturnsLastPageAndShowsEndOfData() {
        AccountPage res = as.getAccounts(16);
        assertFalse(res.getHasNext());
        assertEquals(0, res.getNextPageStart());
        assertEquals(5, res.getAccountInfos().size());
    }

    @Test
    public void accountServiceExhausts() {
        AccountPage page;
        int pages = 0;
        int start = 0;
        do {
            page = as.getAccounts(start);
            start = page.getNextPageStart();
            pages += page.getAccountInfos().isEmpty() ? 0 : 1;
        } while (page.getHasNext());
        assertEquals(3, pages);
    }
}