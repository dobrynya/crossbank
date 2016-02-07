package com.crossbank.front;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.io.OutputStream;
import net.sf.jasperreports.engine.*;
import com.crossbank.model.AccountInfo;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Generates accounts sammary report.
 * @author Dmitry Dobrynin <dobrynya@inbox.ru>
 *         Created at 07.02.2016 17:43
 */
@Component
public class AccountsSummaryReporter {
    @Autowired
    private AccountService accountService;
    private Logger logger = LoggerFactory.getLogger(AccountsSummaryReporter.class);

    JasperReport jasperReport;

    public AccountsSummaryReporter() throws JRException {
        jasperReport = JasperCompileManager.compileReport(getClass().getResourceAsStream("/accountsSummary.jrxml"));
    }

    public void generate(OutputStream outputStream) {
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<String, Object>(), createDataSource());
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        } catch (Exception e) {
            logger.error("Could not generate a report!", e);
            throw new RuntimeException("Could not generate a report!", e);
        } finally {
            try { outputStream.close(); }
            catch (IOException e) { logger.error("Could not close a stream!", e); }
        }
    }

    protected JRDataSource createDataSource() {
        return new JRDataSource() {
            private Iterator<AccountInfo> infos = accountService.accountInfos();
            private AccountInfo current;

            public boolean next() throws JRException {
                if (infos.hasNext()) {
                    current = infos.next();
                    return true;
                }
                return false;
            }

            public Object getFieldValue(JRField jrField) throws JRException {
                switch (jrField.getName()) {
                    case "accountId": return current.getAccount().getId();
                    case "owner": return current.getAccount().getOwner();
                    case "balance": return current.getBalance();
                    case "lastActivity": return current.getLastActivity();
                    default: throw new IllegalArgumentException("Could not get field: " + jrField.getName() + "!");
                }
            }
        };
    }
}
