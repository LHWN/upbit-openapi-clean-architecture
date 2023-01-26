package upbit.project.openapi.service.ticker;

import org.springframework.stereotype.Service;
import upbit.project.openapi.port.in.ticker.SearchTickerUseCase;
import upbit.project.openapi.port.out.ticker.SearchTickerPort;

import java.util.List;

@Service
public class TickerService implements SearchTickerUseCase {
    private final SearchTickerPort searchTickerPort;

    public TickerService (SearchTickerPort searchTickerPort) {
        this.searchTickerPort = searchTickerPort;
    }
    @Override
    public List<String> getTickerBy(String ticker) {
        return null;
    }
}
