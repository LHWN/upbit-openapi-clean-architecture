package upbit.project.openapi.port.out.market;

import upbit.project.openapi.domain.market.Market;

import java.util.List;

public interface MarketPort {
    void saveRepository(Market market);
    Market findByMarketSymbol(String marketSymbol);
    List<Market> searchRepoMarket();
    void save(List<Market> markets);

    void save(Market market);
}
