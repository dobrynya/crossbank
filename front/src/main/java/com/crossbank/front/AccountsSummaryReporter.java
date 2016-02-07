package com.crossbank.front;

import com.crossbank.model.AccountInfo;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.OutputStream;
import java.util.Iterator;

/**
 * Generates accounts sammary report.
 * @author Dmitry Dobrynin <dobrynya@inbox.ru>
 *         Created at 07.02.2016 17:43
 */
@Component
public class AccountsSummaryReporter extends AbstractReporter {
    @Autowired
    private AccountService accountService;

    public void generateAccountsSummaryReport(OutputStream outputStream) {
        generate(outputStream, createDataSource());
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

    public String reportTemplate() { return "/accountsSummary.jrxml"; }
}
