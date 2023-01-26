package upbit.project.openapi.port.in.ticker;

import java.util.List;

public interface SearchTickerUseCase {
    List<String> getTickerBy(String ticker);
}
