package com.tradingapp.trading_service.repositories;

import com.tradingapp.trading_service.models.Trade;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TradeRepository {

    private List<Trade> trades = new ArrayList<>();

    public void addTrade(Trade trade){
        trades.add(trade);
    }

    public Trade findById(Long id){
        return trades.stream().filter(trade -> trade.getId().equals(id)).findFirst().orElseThrow();
    }

    public List<Trade> findAll(){
        return trades;
    }

    public Long nextId(){
        return (long) trades.size();
    }

}
