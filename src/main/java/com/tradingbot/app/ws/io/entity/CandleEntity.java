package com.tradingbot.app.ws.io.entity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "candle")
@Table(name = "candles")
public class CandleEntity {

    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String market;

    @Column(nullable = false)
    private ZonedDateTime timePeriodStart;

    @Column(nullable = false)
    private ZonedDateTime timePeriodEnd;

    @Column(nullable = false)
    private ZonedDateTime timeOpen;

    @Column(nullable = false)
    private ZonedDateTime timeClose;

    @Column(nullable = false)
    private BigDecimal priceOpen;

    @Column(nullable = false)
    private BigDecimal priceClose;

    @Column(nullable = false)
    private BigDecimal priceHigh;

    @Column(nullable = false)
    private BigDecimal priceLow;

    @Column(nullable = false)
    private BigDecimal volumeTraded;

    @Column(nullable = false)
    private int tradesCount;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
