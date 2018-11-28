package com.rppjs.customer.configuration;

import com.rppjs.customer.entities.Customer;
import com.rppjs.customer.entities.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration
@EnableJpaRepositories(
        basePackages = "com.rppjs.customer.repository"
)
public class MySqlConfiguration {

    @Bean
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().url("jdbc:mysql://localhost:3306/Customer_Inventory")
                .driverClassName("com.mysql.jdbc.Driver")
                .username("root")
                .password("pass").build();
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) throws IOException {
        return builder.dataSource(mysqlDataSource())
                .properties((hibernateProperties()))
                .packages(Customer.class, User.class)
                .persistenceUnit("mysqlPU")
                .build();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    private Map<String, Object> hibernateProperties() throws IOException {
        Resource resource = new ClassPathResource("hibernate.properties");
        Properties properties = PropertiesLoaderUtils.loadProperties(resource);
        return properties.entrySet().stream().collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue()));
    }
}
