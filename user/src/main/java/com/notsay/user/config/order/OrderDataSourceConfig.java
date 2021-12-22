package com.notsay.user.config.order;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/22 16:38
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.notsay.user.domain.repo.order"},
        entityManagerFactoryRef = "orderEntityManagerFactory")
public class OrderDataSourceConfig {

    /**
     * 配置数据源   @Primary . 标记为主数据源
     * @return
     */
    @Bean("orderDataSource")
    public DataSource orderDataSource(OrderConfig orderConfig) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(orderConfig.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(orderConfig.getPassword());
        mysqlXaDataSource.setUser(orderConfig.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        //注册到全局事务
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName(orderConfig.getUniqueResourceName());
        return xaDataSource;
    }

    /**
     * 实体管理工厂的bean
     * @param builder
     * @return
     */
    @Bean(name = "orderEntityManagerFactory")
//    @Primary
    public LocalContainerEntityManagerFactoryBean orderEntityManagerFactory(@Qualifier("orderDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                //这个是指向你的domain, entity的路径。 实体类所在的包
                .packages("com.notsay.user.domain.entity.order")
//                .persistenceUnit("primary")
                .build();
    }

    /**
     * 配置 实体管理器
     * @param builder 、
     * @return 、
     */
    @Bean(name = "orderEntityManager")
//    @Primary
    public EntityManager orderEntityManager(@Qualifier("orderDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder){
        return  Objects.requireNonNull(orderEntityManagerFactory(dataSource, builder).getObject()).createEntityManager();
    }

    /**
     * 配置事务管理
     * @param builder 、
     * @return 、
     */
//    @Bean(name = "orderTransactionManager")
////    @Primary
//    public PlatformTransactionManager orderTransactionManager(EntityManagerFactoryBuilder builder) {
//        return new JpaTransactionManager(Objects.requireNonNull(orderEntityManagerFactory(builder).getObject()));
//    }

//    // hibernate 配置
//    @Bean
//    @ConfigurationProperties("spring.jpa.order")
//    public HibernateProperties orderHibernateProperties() {
//        return new HibernateProperties();
//    }
}