package upbit.project.openapi.service.market;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionOperations;
import upbit.project.openapi.domain.market.Market;
import upbit.project.openapi.port.in.market.CreateMarketUseCase;
import upbit.project.openapi.port.out.market.MarketPort;

import java.util.List;

@Service
public class MarketCreateService implements CreateMarketUseCase {

    private final MarketPort marketPort;

    private final TransactionOperations writeTransactionOperations;

    public MarketCreateService(MarketPort marketPort, TransactionOperations writeTransactionOperations) {
        this.marketPort = marketPort;
        this.writeTransactionOperations = writeTransactionOperations;
    }

    @Override
    @Transactional(readOnly = false)
    public void save(List<Market> markets) {
        writeTransactionOperations.executeWithoutResult(status -> marketPort.save(markets));
    }

    @Override
    @Transactional(readOnly = false)
    public void save(String market, String koreanName, String englishName, String marketWarning) {
        writeTransactionOperations.executeWithoutResult(status -> marketPort.save(Market.builder()
                .market(market)
                .koreanName(koreanName)
                .englishName(englishName)
                .marketWarning(marketWarning)
                .build()));
    }
}
