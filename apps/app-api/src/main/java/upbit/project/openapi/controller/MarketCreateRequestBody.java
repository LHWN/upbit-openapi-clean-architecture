package upbit.project.openapi.controller;

import lombok.Builder;
import lombok.Getter;

import java.beans.ConstructorProperties;
@Getter
public class MarketCreateRequestBody {
    private final String market;
    private final String koreanName;
    private final String englishName;
    private final String marketWarning;

    @Builder
    @ConstructorProperties({"market", "koreanName", "englishName", "marketWarning"})
    public MarketCreateRequestBody(String market, String koreanName, String englishName, String marketWarning) {
        this.market = market;
        this.koreanName = koreanName;
        this.englishName = englishName;
        this.marketWarning = marketWarning;
    }
}
