package upbit.project.openapi.port.in.market;

import org.springframework.context.annotation.Configuration;
import upbit.project.openapi.domain.market.Market;

import java.util.List;


public interface SearchMarketUseCase {
    public List<Market> searchRepoMarket();
}
