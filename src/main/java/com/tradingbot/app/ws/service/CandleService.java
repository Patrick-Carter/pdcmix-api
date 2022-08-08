package com.tradingbot.app.ws.service;

import java.time.Duration;
import java.util.ArrayList;

import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseBar;
import org.ta4j.core.BaseBarSeries;

import com.tradingbot.app.ws.io.entity.CandleEntity;
import com.tradingbot.app.ws.repo.ICandleRepo;
import com.tradingbot.app.ws.trading.definitions.CandleDto;

@Service("candleService")
public class CandleService {

    @Autowired
    private ICandleRepo candleRepo;

    public CandleDto createCandle(CandleDto candle) {
        CandleEntity candleEntity = new CandleEntity();

        BeanUtils.copyProperties(candle, candleEntity);

        CandleEntity newCandle = candleRepo.save(candleEntity);

        CandleDto returnValue = new CandleDto();
        BeanUtils.copyProperties(newCandle, returnValue);

        return returnValue;
    }

    public BarSeries retrieveAllCandles(String market) {
        BarSeries barSeries = new BaseBarSeries(market);
        ArrayList<CandleEntity> candles = candleRepo.findAllByMarket(market);

        candles.forEach(candle -> {
            Duration duration = Duration.ofHours(1);
            Bar bar = new BaseBar(
                    duration,
                    candle.getTimePeriodEnd(),
                    candle.getPriceOpen(),
                    candle.getPriceHigh(),
                    candle.getPriceLow(),
                    candle.getPriceClose(),
                    candle.getVolumeTraded());
            barSeries.addBar(bar, false);
        });

        return barSeries;
    }

}
