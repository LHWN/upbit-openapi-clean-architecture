package upbit.project.openapi.converter.market;

import org.springframework.stereotype.Service;
import upbit.project.openapi.configuration.mapstruct.MapStructConfig;
import upbit.project.openapi.domain.market.Market;
import upbit.project.openapi.http.adapter.UpbitMarket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
public interface MarketConverter {
    Market convert(UpbitMarket source);

    List<Market> convert(List<UpbitMarket> sources);
}
