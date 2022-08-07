package com.tradingbot.app.ws.trading.factories;

import org.springframework.stereotype.Component;
import org.ta4j.core.Indicator;
import org.ta4j.core.indicators.AbstractEMAIndicator;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.DoubleEMAIndicator;
import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.indicators.HMAIndicator;
import org.ta4j.core.indicators.KAMAIndicator;
import org.ta4j.core.indicators.LWMAIndicator;
import org.ta4j.core.indicators.MMAIndicator;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.indicators.TripleEMAIndicator;
import org.ta4j.core.indicators.WMAIndicator;
import org.ta4j.core.indicators.ZLEMAIndicator;
import org.ta4j.core.num.Num;

@Component
public class IndicatorFactory {

    public Indicator<Num> createIndicator(String type, Indicator<Num> priceIndicator, int[] settings)
            throws IllegalArgumentException {
        switch (type) {
            case "DoubleEMA": {
                settingsValidator(settings, 1);
                final int[] arr = new int[] { 9 };
                setSettings(settings, arr);
                return new DoubleEMAIndicator(priceIndicator, settings[0]);
            }
            case "EMA": {
                settingsValidator(settings, 1);
                final int[] arr = new int[] { 9 };
                setSettings(settings, arr);
                return new EMAIndicator(priceIndicator, settings[0]);
            }
            case "HMA": {
                settingsValidator(settings, 1);
                int[] arr = new int[] { 9 };
                setSettings(settings, arr);
                return new HMAIndicator(priceIndicator, settings[0]);
            }
            case "KAMA": {
                settingsValidator(settings, 3);
                int[] arr = new int[] { 5, 2, 20 };
                setSettings(settings, arr);
                return new KAMAIndicator(priceIndicator, settings[0], settings[1], settings[2]);
            }
            case "LWMA": {
                settingsValidator(settings, 1);
                int[] arr = new int[] { 9 };
                setSettings(settings, arr);
                return new LWMAIndicator(priceIndicator, settings[0]);
            }
            case "MMA": {
                settingsValidator(settings, 1);
                int[] arr = new int[] { 9 };
                setSettings(settings, arr);
                return new MMAIndicator(priceIndicator, settings[0]);
            }
            case "SMA": {
                settingsValidator(settings, 1);
                int[] arr = new int[] { 9 };
                setSettings(settings, arr);
                return new SMAIndicator(priceIndicator, settings[0]);
            }
            case "TripleEMA": {
                settingsValidator(settings, 1);
                int[] arr = new int[] { 9 };
                setSettings(settings, arr);
                return new TripleEMAIndicator(priceIndicator, settings[0]);
            }
            case "WMA": {
                settingsValidator(settings, 1);
                int[] arr = new int[] { 9 };
                setSettings(settings, arr);
                return new WMAIndicator(priceIndicator, settings[0]);
            }
            case "ZLMA": {
                settingsValidator(settings, 1);
                int[] arr = new int[] { 9 };
                setSettings(settings, arr);
                return new ZLEMAIndicator(priceIndicator, settings[0]);
            }
            default:
                throw new IllegalArgumentException("Unknown indicator type: " + type);
        }
    }

    private void settingsValidator(int[] settings, Integer expectedSize) {
        if (settings != null && settings.length != expectedSize) {
            throw new IllegalArgumentException("Invalid settings for indicator");
        }
    }

    private int[] setSettings(int[] settings, int[] defaultSettings) {
        if (settings == null) {
            return defaultSettings;
        }
        return settings;
    }
}
