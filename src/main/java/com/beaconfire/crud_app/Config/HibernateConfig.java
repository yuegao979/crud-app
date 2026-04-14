package com.beaconfire.crud_app.Config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
    private HibernateProperties hp;

    @Autowired
    public void setHibernateProperties(HibernateProperties hp) {this.hp = hp;}

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(hp.getDriver());
        ds.setUrl(hp.getUrl());
        ds.setUsername(hp.getUsername());
        ds.setPassword(hp.getPassword());
        return ds;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean fb = new LocalSessionFactoryBean();
        fb.setDataSource(dataSource());
        fb.setPackagesToScan("com.beaconfire.crud_app.Entity");

        Properties p = new Properties();
        p.put("hibernate.dialect", hp.getDialect());
        p.put("hibernate.show_sql", hp.getShow_sql());
        fb.setHibernateProperties(p);

        return fb;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sf) {
        return new HibernateTransactionManager(sf);
    }
}
