package upbit.project.openapi.persistence.market;


import com.mysema.commons.lang.Assert;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.error.Mark;
import upbit.project.openapi.domain.market.Market;
import upbit.project.openapi.domain.market.QMarket;
import upbit.project.openapi.http.adapter.UpbitMarket;
import upbit.project.openapi.port.out.market.MarketPort;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.querydsl.jpa.JPAExpressions.selectFrom;

@Repository
public class MarketJpaRepository extends QuerydslRepositorySupport implements MarketPort {
    public MarketJpaRepository() {
        super(Market.class);
    }

    @PersistenceContext
    @Override
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }

    @Override
    public void saveRepository(Market market) {
        EntityManager entityManager = getEntityManager();
        Assert.notNull(entityManager, "Entity must not null");
        entityManager.persist(market);
        entityManager.flush();
    }

    @Override
    public Market findByMarketSymbol(String marketSymbol) {
        return null;
    }

    @Override
    public List<Market> searchRepoMarket() {
        EntityManager entityManager = getEntityManager();
        JPAQueryFactory query = new JPAQueryFactory(entityManager);
        QMarket qMarket = QMarket.market;
        List<Market> result = query.selectFrom(qMarket).fetch();

        return result;
    }

    @Override
    public void save(List<Market> markets) {
        EntityManager entityManager = getEntityManager();
        Assert.notNull(entityManager, "EntityManager must not be null");
        entityManager.persist(markets.get(0));
        entityManager.flush();
    }

    @Override
    public void save(Market market) {
        EntityManager entityManager = getEntityManager();
        Assert.notNull(entityManager, "EntityManager must not be null");
        entityManager.persist(market);
        entityManager.flush();
    }

}
