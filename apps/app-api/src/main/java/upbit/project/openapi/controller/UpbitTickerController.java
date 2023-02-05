package upbit.project.openapi.controller;

import org.springframework.web.bind.annotation.*;
import upbit.project.openapi.domain.market.Market;
import upbit.project.openapi.http.adapter.UpbitHttpTickerClient;
import upbit.project.openapi.http.adapter.UpbitMarket;
import upbit.project.openapi.persistence.market.MarketJpaRepository;
import upbit.project.openapi.port.in.market.CreateMarketUseCase;
import upbit.project.openapi.port.in.market.SearchMarketUseCase;
import upbit.project.openapi.port.in.ticker.SearchTickerUseCase;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UpbitTickerController {

    private final SearchMarketUseCase searchMarketUseCase;
    private final CreateMarketUseCase createMarketUseCase;
    private final UpbitHttpTickerClient upbitHttpTickerClient;
    private final MarketJpaRepository marketJpaRepository;

    public UpbitTickerController(SearchMarketUseCase searchMarketUseCase, CreateMarketUseCase createMarketUseCase, UpbitHttpTickerClient upbitHttpTickerClient, MarketJpaRepository marketJpaRepository) {
        this.searchMarketUseCase = searchMarketUseCase;
        this.createMarketUseCase = createMarketUseCase;
        this.upbitHttpTickerClient = upbitHttpTickerClient;
        this.marketJpaRepository = marketJpaRepository;
    }

    @GetMapping("/v1/upbit/ticker/{ticker}")
    public String getUpbitTickerBy(@PathVariable String ticker) {
        return null;
    }

    @GetMapping("/v1/market/all")
    public List<UpbitMarket> getAllMarkets() {
        return upbitHttpTickerClient.getAllMarket();
    }

    @GetMapping("/v1/repo/market/all")
    public List<Market> searchMarket() {
        List<Market> result = searchMarketUseCase.searchRepoMarket();
        return result;
    }

    @PostMapping("/v1/repo/market/save")
    public void saveMarket(
            @RequestBody List<MarketCreateRequestBody> requestBody
    ) {
        requestBody.forEach(market -> createMarketUseCase.save(
                market.getMarket(),
                market.getKoreanName(),
                market.getEnglishName(),
                market.getMarketWarning()
        ));

    }

    @PostMapping("/v1/test/save")
    public void testSave() {
        List<Market> testData = new ArrayList<Market>();
        testData.add(Market.builder()
                        .koreanName("비트코인")
                        .englishName("bitcoin")
                        .marketWarning(null)
                        .build());
        createMarketUseCase.save(testData);
    }
}
