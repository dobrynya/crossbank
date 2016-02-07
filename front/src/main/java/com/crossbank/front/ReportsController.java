package com.crossbank.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Provides reports.
 * @author Dmitry Dobrynin
 * Created at 06.02.16 23:44.
 */
@RestController
public class ReportsController {
    @Autowired
    private AccountsSummaryReporter accountsSummaryReporter;
    @Autowired
    private FinancialPositionReporter financialPositionReporter;

    @RequestMapping("/")
    public void redirectToIndex(HttpServletResponse response) throws IOException {
        response.sendRedirect("index.html");
    }

    @RequestMapping(value = "/accountsSummary", method = RequestMethod.GET)
    public void accountsSummary(HttpServletResponse response) throws IOException {
        accountsSummaryReporter.generateAccountsSummaryReport(response.getOutputStream());
    }

    @RequestMapping(value = "/financialPosition", method = RequestMethod.GET)
    public void financialPosition(@RequestParam("year") int year, HttpServletResponse response) throws IOException {
        financialPositionReporter.generateFinancialPositionReport(year, response.getOutputStream());
    }
}