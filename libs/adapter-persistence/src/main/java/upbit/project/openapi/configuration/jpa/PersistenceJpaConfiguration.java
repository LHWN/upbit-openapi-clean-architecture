package upbit.project.openapi.configuration.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import upbit.project.openapi.domain.DomainModule;
import upbit.project.openapi.persistence.PersistenceModule;


@Configuration
@EntityScan(basePackageClasses = DomainModule.class)
@EnableJpaRepositories(basePackageClasses = PersistenceModule.class)
public class PersistenceJpaConfiguration {
    @Bean
    public TransactionTemplate writeTransactionOperations(PlatformTransactionManager transactionManager) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.setReadOnly(false);
        return transactionTemplate;
    }

    public TransactionTemplate readTransactionOperations(PlatformTransactionManager transactionManager) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.setReadOnly(false);
        return transactionTemplate;
    }
}


