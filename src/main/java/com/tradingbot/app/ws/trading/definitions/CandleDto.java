package com.tradingbot.app.ws.trading.definitions;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonAlias;

public class CandleDto {
    @JsonAlias("time_period_start")
    ZonedDateTime timePeriodStart;

    @JsonAlias("time_period_end")
    ZonedDateTime timePeriodEnd;

    @JsonAlias("time_open")
    ZonedDateTime timeOpen;

    @JsonAlias("time_close")
    ZonedDateTime timeClose;

    @JsonAlias("price_open")
    BigDecimal priceOpen;

    @JsonAlias("price_close")
    BigDecimal priceClose;

    @JsonAlias("price_high")
    BigDecimal priceHigh;

    @JsonAlias("price_low")
    BigDecimal priceLow;

    @JsonAlias("volume_traded")
    BigDecimal volumeTraded;

    @JsonAlias("trades_count")
    int tradesCount;

    String market;

    public String getMarket() {
        return market;
    }
    public void setMarket(String market) {
        this.market = market;
    }
    public ZonedDateTime getTimePeriodStart() {
        return timePeriodStart;
    }
    public void setTimePeriodStart(ZonedDateTime timePeriodStart) {
        this.timePeriodStart = timePeriodStart;
    }
    public ZonedDateTime getTimePeriodEnd() {
        return timePeriodEnd;
    }
    public void setTimePeriodEnd(ZonedDateTime timePeriodEnd) {
        this.timePeriodEnd = timePeriodEnd;
    }
    public ZonedDateTime getTimeOpen() {
        return timeOpen;
    }
    public void setTimeOpen(ZonedDateTime timeOpen) {
        this.timeOpen = timeOpen;
    }
    public ZonedDateTime getTimeClose() {
        return timeClose;
    }
    public void setTimeClose(ZonedDateTime timeClose) {
        this.timeClose = timeClose;
    }
    public BigDecimal getPriceOpen() {
        return priceOpen;
    }
    public void setPriceOpen(BigDecimal priceOpen) {
        this.priceOpen = priceOpen;
    }
    public BigDecimal getPriceClose() {
        return priceClose;
    }
    public void setPriceClose(BigDecimal priceClose) {
        this.priceClose = priceClose;
    }
    public BigDecimal getPriceHigh() {
        return priceHigh;
    }
    public void setPriceHigh(BigDecimal priceHigh) {
        this.priceHigh = priceHigh;
    }
    public BigDecimal getPriceLow() {
        return priceLow;
    }
    public void setPriceLow(BigDecimal priceLow) {
        this.priceLow = priceLow;
    }
    public BigDecimal getVolumeTraded() {
        return volumeTraded;
    }
    public void setVolumeTraded(BigDecimal volumeTraded) {
        this.volumeTraded = volumeTraded;
    }
    public int getTradesCount() {
        return tradesCount;
    }
    public void setTradesCount(int tradesCount) {
        this.tradesCount = tradesCount;
    }
}
