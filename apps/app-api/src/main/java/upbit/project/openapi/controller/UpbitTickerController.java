package upbit.project.openapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import upbit.project.openapi.domain.market.Market;
import upbit.project.openapi.http.adapter.UpbitHttpTickerClient;
import upbit.project.openapi.http.adapter.UpbitMarket;
import upbit.project.openapi.port.in.ticker.SearchTickerUseCase;

import java.util.List;

@RestController
public class UpbitTickerController {

    private final SearchTickerUseCase searchTickerUseCase;
    private final UpbitHttpTickerClient upbitHttpTickerClient;


    public UpbitTickerController(SearchTickerUseCase searchTickerUseCase, UpbitHttpTickerClient upbitHttpTickerClient) {
        this.searchTickerUseCase = searchTickerUseCase;
        this.upbitHttpTickerClient = upbitHttpTickerClient;
    }

    @GetMapping("/v1/upbit/ticker/{ticker}")
    public String getUpbitTickerBy(@PathVariable String ticker) {
        return null;
    }

    @GetMapping("/v1/market/all")
    public List<UpbitMarket> getAllMarkets() {
        return upbitHttpTickerClient.getAllMarket();
    }
}
