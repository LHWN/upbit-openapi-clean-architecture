package upbit.project.openapi.service.market;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upbit.project.openapi.domain.market.Market;
import upbit.project.openapi.port.in.market.SearchMarketUseCase;
import upbit.project.openapi.port.out.market.MarketPort;

import java.util.List;
@Service
public class MarketSearchService implements SearchMarketUseCase {
    private final MarketPort marketPort;

    public MarketSearchService(MarketPort marketPort) {
        this.marketPort = marketPort;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Market> searchRepoMarket() {
        List<Market> result = marketPort.searchRepoMarket();
        return result;
    }
}
