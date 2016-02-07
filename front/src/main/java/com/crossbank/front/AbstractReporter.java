package com.crossbank.front;

import net.sf.jasperreports.engine.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * Provides base abilities to generate a report.
 * @author Dmitry Dobrynin <dobrynya@inbox.ru>
 *         Created at 08.02.2016 0:37
 */
public abstract class AbstractReporter {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public abstract String reportTemplate();

    protected JasperReport jasperReport;

    public AbstractReporter() {
        try {
            compileReport();
        } catch (JRException e) {
            logger.error("Could not compile report template!", e);
            throw new RuntimeException("Could not compile report template!", e);
        }
    }

    protected void compileReport() throws JRException {
        jasperReport = JasperCompileManager.compileReport(getClass().getResourceAsStream(reportTemplate()));
    }

    protected void generate(OutputStream outputStream, JRDataSource dataSource) {
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<String, Object>(), dataSource);
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        } catch (Exception e) {
            logger.error("Could not generate a report!", e);
            throw new RuntimeException("Could not generate a report!", e);
        } finally {
            try { outputStream.close(); }
            catch (IOException e) { logger.error("Could not close a stream!", e); }
        }
    }
}
