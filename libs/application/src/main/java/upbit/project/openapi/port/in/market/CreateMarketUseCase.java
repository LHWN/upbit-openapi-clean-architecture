package upbit.project.openapi.port.in.market;


import upbit.project.openapi.domain.market.Market;

import java.util.List;

public interface CreateMarketUseCase {
    public void save(List<Market> markets);
    public void save(String market, String koreanName, String englishName, String marketWarning);
}
