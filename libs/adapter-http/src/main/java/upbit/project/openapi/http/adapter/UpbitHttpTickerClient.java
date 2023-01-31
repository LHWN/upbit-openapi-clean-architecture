package upbit.project.openapi.http.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import upbit.project.openapi.converter.market.MarketConverter;
import upbit.project.openapi.domain.market.Market;
import org.junit.platform.commons.util.StringUtils;
import upbit.project.openapi.port.out.ticker.SearchTickerPort;
import upbit.project.openapi.protocol.deserializer.JsonDeserializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Slf4j
@Component
public class UpbitHttpTickerClient implements SearchTickerPort {

    private final JsonDeserializer jsonDeserializer;

    public UpbitHttpTickerClient(JsonDeserializer jsonDeserializer) {
        this.jsonDeserializer = jsonDeserializer;
    }

    @Override
    public List<UpbitMarket> getAllMarket() {
        UpbitRequestType requestType = UpbitRequestType.MARKET_ALL_V1;
        UpbitRequestQuery query = UpbitRequestQuery.builder()
                .url(UpbitRequestType.getFullUrl(requestType))
                .body(null)
                .param("isDetails=" + false)
                .method(requestType.getMethod())
                .build();
        String data = request(query);
        System.out.println(data);
        List<UpbitMarket> result = jsonDeserializer.deserializeAsList(data,UpbitMarket.class);
        return result;
    }

    public String request(UpbitRequestQuery query) {
        try {
            URL url = new URL(query.getUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(query.getMethod().name());
            conn.setRequestProperty("Content-Type", "application/json");
            // URL 접속 객체 conn 을 URLConnection 객체에 쓰기가 가능하도록 지정한다. default 는 false 이므로 true 로 지정하지 않으면 쓰기가 불가능하다.
            conn.setDoOutput(true);

            if(StringUtils.isNotBlank(query.getBody())) {
                OutputStream os = conn.getOutputStream();
                os.write(query.getBody().getBytes());
                os.flush();
            }

            return getApiResponse(conn);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getApiResponse(HttpURLConnection conn) {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String inputLine;

            while((inputLine = br.readLine()) != null) { // br.readline 을 inputline 에 먼저 할당하고 그게 null 이 나오기 직전까찌
                stringBuilder.append(inputLine);
            }

            br.close();
            return stringBuilder.toString();
        } catch (Exception e) {
            log.error("failed to get api response: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
