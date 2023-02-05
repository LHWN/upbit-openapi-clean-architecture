package upbit.project.openapi.domain.market;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "markets")
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "market_id")
    private String marketId;

    @Column(name = "market")
    private String market;
    @Column(name = "market_korean_name")
    private String koreanName;
    @Column(name = "market_english_name")
    private String englishName;
    @Column(name = "market_warning")
    private String marketWarning;

    @Builder
    public Market(String marketId, String market, String koreanName, String englishName, String marketWarning) {
        this.marketId = marketId;
        this.market = market;
        this.koreanName = koreanName;
        this.englishName = englishName;
        this.marketWarning = marketWarning;
    }

    public Market() {}
}
