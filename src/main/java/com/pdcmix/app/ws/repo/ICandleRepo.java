package com.tradingbot.app.ws.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tradingbot.app.ws.io.entity.CandleEntity;

import java.util.ArrayList;
import java.util.UUID;


@Repository
public interface ICandleRepo extends CrudRepository<CandleEntity, UUID> {
    ArrayList<CandleEntity> findAllByMarket(String market);
}
