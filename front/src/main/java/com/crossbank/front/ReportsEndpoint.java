package com.crossbank.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Provides reports.
 * @author Dmitry Dobrynin
 * Created at 06.02.16 23:44.
 */
@RestController
public class ReportsEndpoint {
    @Autowired
    private AccountsSummaryReporter accountsSummaryReporter;

    @RequestMapping("/")
    public void redirectToIndex(HttpServletResponse response) throws IOException {
        response.sendRedirect("index.html");
    }

    @RequestMapping(value = "/accountsSummary", method = RequestMethod.GET)
    public void accountsSummary(HttpServletResponse response) throws IOException {
        accountsSummaryReporter.generate(response.getOutputStream());
    }

    @RequestMapping(value = "/transactionsSummary", method = RequestMethod.GET)
    public void transactionsSummary(HttpServletResponse response) throws IOException {
        throw new RuntimeException("Not implemented yet!");
    }
}