package com.tradingbot.app.ws.trading.generators;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseStrategy;
import org.ta4j.core.Indicator;
import org.ta4j.core.Rule;
import org.ta4j.core.Strategy;
import org.ta4j.core.num.Num;
import org.ta4j.core.rules.AbstractRule;

import com.tradingbot.app.ws.trading.definitions.TradingDto;
import com.tradingbot.app.ws.trading.factories.AbstractRuleFactory;
import com.tradingbot.app.ws.trading.factories.IndicatorFactory;
import com.tradingbot.app.ws.trading.factories.PriceSelectionFactory;

@Component
public class StrategyGenerator {

    @Autowired
    private IndicatorFactory indicatorFactory = new IndicatorFactory();

    @Autowired
    private AbstractRuleFactory ruleFactory = new AbstractRuleFactory();

    @Autowired
    private PriceSelectionFactory priceSelectionFactory = new PriceSelectionFactory();

    private ArrayList<TradingDto> tradingDefinitions;

    private String strategyName;

    private BarSeries series;

    public StrategyGenerator() {}

    public StrategyGenerator(ArrayList<TradingDto> tradingDefinitions, String strategyName, BarSeries series) {
        this.tradingDefinitions = tradingDefinitions;
        this.strategyName = strategyName;
        this.series = series;
    }

    public Strategy generate() throws IllegalArgumentException {

        Rule buyRule = null;
        Rule sellRule = null;

        for (TradingDto td : tradingDefinitions) {
            Indicator<Num> priceSelector = priceSelectionFactory.createPriceSelector(td.getPriceMoment(), this.series);
            Indicator<Num> indicator = indicatorFactory.createIndicator(td.getIndicator(), priceSelector, td.getSettings());
            AbstractRule br = ruleFactory.createRule(td.getBuyRule(), indicator, priceSelector);
            AbstractRule sr = ruleFactory.createRule(td.getSellRule(), indicator, priceSelector);

            if (buyRule == null) {
                buyRule = br;
            } else {
                buyRule = buyRule.and(br);
            }

            if (sellRule == null) {
                sellRule = sr;
            } else {
                sellRule = sellRule.and(sr);
            }
        }

        return new BaseStrategy(strategyName ,buyRule, sellRule, 20);
    }
}
