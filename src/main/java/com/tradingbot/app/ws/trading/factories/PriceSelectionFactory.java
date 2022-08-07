package com.tradingbot.app.ws.trading.factories;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import org.ta4j.core.indicators.helpers.PriceIndicator;

public class PriceSelectionFactory {
    public PriceIndicator createPriceSelector(String type, BarSeries series) throws IllegalArgumentException {
        switch(type) {
            case "Close": {
                return new ClosePriceIndicator(series);
            }
            default: {
                throw new IllegalArgumentException("Unknown price selector type: " + type);
            }
        }
    }
}
