package com.crossbank.front;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.OutputStream;
import java.util.Collections;

/**
 * Generates report on financial position.
 * @author Dmitry Dobrynin <dobrynya@inbox.ru>
 *         Created at 08.02.2016 0:36
 */
@Component
public class FinancialPositionReporter extends AbstractReporter {
    @Autowired
    private FinancialPositionService positionService;

    public void generateFinancialPositionReport(int year, OutputStream outputStream) {
        generate(outputStream, new JRBeanCollectionDataSource(Collections.singletonList(
                positionService.getFinancialPosition(year)
        )));
    }

    public String reportTemplate() {
        return "/financialPosition.jrxml";
    }
}
