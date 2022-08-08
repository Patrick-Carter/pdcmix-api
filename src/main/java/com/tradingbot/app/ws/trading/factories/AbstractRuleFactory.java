package com.tradingbot.app.ws.trading.factories;

import org.springframework.stereotype.Component;
import org.ta4j.core.Indicator;
import org.ta4j.core.num.Num;
import org.ta4j.core.rules.AbstractRule;
import org.ta4j.core.rules.CrossedDownIndicatorRule;
import org.ta4j.core.rules.CrossedUpIndicatorRule;
import org.ta4j.core.rules.OverIndicatorRule;
import org.ta4j.core.rules.UnderIndicatorRule;

@Component
public class AbstractRuleFactory {
    public AbstractRule createRule(String type, Indicator<Num> indicator, Indicator<Num> priceIndicator) throws IllegalArgumentException {
        switch (type) {
            case "OverIndicator": {
                return new OverIndicatorRule(priceIndicator, indicator);
            }
            case "UnderIndicator": {
                return new UnderIndicatorRule(priceIndicator, indicator);
            }
            case "CrossedUpIndicator": {
                return new CrossedUpIndicatorRule(priceIndicator, indicator);
            }
            case "CrossedDownIndicator": {
                return new CrossedDownIndicatorRule(priceIndicator, indicator);
            }
            default: {
                throw new IllegalArgumentException("Unknown rule type: " + type);
            }
        }
    }
}
