package upbit.project.openapi.converter.market;

import org.mapstruct.Mapping;
import upbit.project.openapi.configuration.mapstruct.MapStructConfig;
import upbit.project.openapi.domain.market.Market;
import upbit.project.openapi.http.adapter.UpbitMarket;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface MarketConverter {
    @Mapping(source="market", target="marketSymbol")
    Market convert(UpbitMarket source);

    @Mapping(source="market", target="marketSymbol")
    List<Market> convert(List<UpbitMarket> sources);
}
