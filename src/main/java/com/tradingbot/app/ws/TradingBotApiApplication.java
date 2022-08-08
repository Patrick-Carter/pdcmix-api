package com.tradingbot.app.ws;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.ta4j.core.BarSeries;
import org.ta4j.core.BarSeriesManager;
import org.ta4j.core.Strategy;
import org.ta4j.core.TradingRecord;
import org.ta4j.core.Trade.TradeType;
import org.ta4j.core.analysis.criteria.WinningPositionsRatioCriterion;
import org.ta4j.core.analysis.criteria.pnl.GrossLossCriterion;
import org.ta4j.core.analysis.criteria.pnl.GrossProfitCriterion;
import org.ta4j.core.analysis.criteria.pnl.GrossReturnCriterion;
import org.ta4j.core.analysis.criteria.pnl.NetProfitCriterion;
import org.ta4j.core.analysis.criteria.pnl.ProfitLossPercentageCriterion;
import org.ta4j.core.analysis.criteria.pnl.ProfitLossRatioCriterion;
import org.ta4j.core.num.Num;

import com.tradingbot.app.ws.service.CandleService;
import com.tradingbot.app.ws.trading.definitions.TradingDto;
import com.tradingbot.app.ws.trading.generators.StrategyGenerator;

@SpringBootApplication
public class TradingBotApiApplication implements CommandLineRunner {

	@Autowired
	CandleService candleService;

	public static void main(String[] args) {
		SpringApplication.run(TradingBotApiApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running...");
		BarSeries barSeries = candleService.retrieveAllCandles("BTC/USD");

		ArrayList<TradingDto> tradingDef = new ArrayList<TradingDto>();
		int[] arr = new int[] { 9 };
		TradingDto td = new TradingDto("SMA", "CrossedUpIndicator", "CrossedDownIndicator", "Close", arr);
		tradingDef.add(td);

		StrategyGenerator strategyGenerator = new StrategyGenerator(tradingDef, "SMA", barSeries);
		Strategy strategy = strategyGenerator.generate();
		BarSeriesManager seriesManager = new BarSeriesManager(barSeries);
		TradingRecord tradingRecord = seriesManager.run(strategy, TradeType.BUY, barSeries.numOf(0.5));

		System.out.println(
				"Total Profit for the strategy: " + (new GrossProfitCriterion().calculate(barSeries, tradingRecord)));

		System.out.println(
				"Total loss for the strategy: " + (new GrossLossCriterion().calculate(barSeries, tradingRecord)));

		System.out.println(
				"Total return for the strategy: " + (new GrossReturnCriterion().calculate(barSeries, tradingRecord)));

		System.out.println(
				"Total net for the strategy: " + (new WinningPositionsRatioCriterion().calculate(barSeries, tradingRecord)));
	}

}
