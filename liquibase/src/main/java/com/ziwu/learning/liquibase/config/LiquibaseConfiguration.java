package com.ziwu.learning.liquibase.config;


import liquibase.Liquibase;
import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfiguration {
    private final DataSource dataSource;

    public LiquibaseConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new MySpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/changelog/changelog.xml");
        liquibase.setShouldRun(true);
        return liquibase;
    }

    private static class MySpringLiquibase extends SpringLiquibase {
        @Override
        protected void performUpdate(Liquibase liquibase) throws LiquibaseException {
            super.performUpdate(liquibase);
        }
    }
}
