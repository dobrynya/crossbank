package com.crossbank.model;

/**
 * Contains financial position data.
 * @author Dmitry Dobrynin <dobrynya@inbox.ru>
 *         Created at 08.02.2016 0:00
 */
public class FinancialPosition {
    private String cashAndDue, interestEarningDeposits, centralBankFundsSold, tradingAssets, positiveMarketValues, financialAssetsDesignated,
            securitiesPurchasedUnderResale, securitiesBorrowed, loans, brokerageAndSecurities, remainingAssets, year;

    public FinancialPosition() {}

    public FinancialPosition(String year, String cashAndDue, String interestEarningDeposits, String centralBankFundsSold, String tradingAssets,
                             String positiveMarketValues, String financialAssetsDesignated, String securitiesPurchasedUnderResale,
                             String securitiesBorrowed, String loans, String brokerageAndSecurities, String remainingAssets) {
        this.year = year;
        this.cashAndDue = cashAndDue;
        this.interestEarningDeposits = interestEarningDeposits;
        this.centralBankFundsSold = centralBankFundsSold;
        this.tradingAssets = tradingAssets;
        this.positiveMarketValues = positiveMarketValues;
        this.financialAssetsDesignated = financialAssetsDesignated;
        this.securitiesPurchasedUnderResale = securitiesPurchasedUnderResale;
        this.securitiesBorrowed = securitiesBorrowed;
        this.loans = loans;
        this.brokerageAndSecurities = brokerageAndSecurities;
        this.remainingAssets = remainingAssets;
    }

    public String getCashAndDue() {
        return cashAndDue;
    }

    public void setCashAndDue(String cashAndDue) {
        this.cashAndDue = cashAndDue;
    }

    public String getInterestEarningDeposits() {
        return interestEarningDeposits;
    }

    public void setInterestEarningDeposits(String interestEarningDeposits) {
        this.interestEarningDeposits = interestEarningDeposits;
    }

    public String getCentralBankFundsSold() {
        return centralBankFundsSold;
    }

    public void setCentralBankFundsSold(String centralBankFundsSold) {
        this.centralBankFundsSold = centralBankFundsSold;
    }

    public String getTradingAssets() {
        return tradingAssets;
    }

    public void setTradingAssets(String tradingAssets) {
        this.tradingAssets = tradingAssets;
    }

    public String getPositiveMarketValues() {
        return positiveMarketValues;
    }

    public void setPositiveMarketValues(String positiveMarketValues) {
        this.positiveMarketValues = positiveMarketValues;
    }

    public String getFinancialAssetsDesignated() {
        return financialAssetsDesignated;
    }

    public void setFinancialAssetsDesignated(String financialAssetsDesignated) {
        this.financialAssetsDesignated = financialAssetsDesignated;
    }

    public String getSecuritiesPurchasedUnderResale() {
        return securitiesPurchasedUnderResale;
    }

    public void setSecuritiesPurchasedUnderResale(String securitiesPurchasedUnderResale) {
        this.securitiesPurchasedUnderResale = securitiesPurchasedUnderResale;
    }

    public String getSecuritiesBorrowed() {
        return securitiesBorrowed;
    }

    public void setSecuritiesBorrowed(String securitiesBorrowed) {
        this.securitiesBorrowed = securitiesBorrowed;
    }

    public String getLoans() {
        return loans;
    }

    public void setLoans(String loans) {
        this.loans = loans;
    }

    public String getBrokerageAndSecurities() {
        return brokerageAndSecurities;
    }

    public void setBrokerageAndSecurities(String brokerageAndSecurities) {
        this.brokerageAndSecurities = brokerageAndSecurities;
    }

    public String getRemainingAssets() {
        return remainingAssets;
    }

    public void setRemainingAssets(String remainingAssets) {
        this.remainingAssets = remainingAssets;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
