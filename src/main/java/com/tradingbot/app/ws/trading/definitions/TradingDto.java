package com.tradingbot.app.ws.trading.definitions;

public class TradingDto {
    String indicator;
    String buyRule;
    String sellRule;
    String priceMoment;

    int[] settings;

    public TradingDto(String indicator, String buyRule, String sellRule, String priceMoment, int[] settings) {
        this.indicator = indicator;
        this.buyRule = buyRule;
        this.sellRule = sellRule;
        this.priceMoment = priceMoment;
        this.settings = settings;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getBuyRule() {
        return buyRule;
    }

    public void setBuyRule(String buyRule) {
        this.buyRule = buyRule;
    }

    public String getSellRule() {
        return sellRule;
    }

    public void setSellRule(String sellRule) {
        this.sellRule = sellRule;
    }

    public String getPriceMoment() {
        return priceMoment;
    }

    public void setPriceMoment(String priceMoment) {
        this.priceMoment = priceMoment;
    }

    public int[] getSettings() {
        return settings;
    }

    public void setSettings(int[] settings) {
        this.settings = settings;
    }
}
