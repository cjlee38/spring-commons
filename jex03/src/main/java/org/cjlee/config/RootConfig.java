package org.cjlee.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages= {"org.cjlee.service"})
@MapperScan(basePackages= {"org.cjlee.mapper"})
public class RootConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:XE");

        hikariConfig.setUsername("book_ex");
        hikariConfig.setPassword("book_ex");

        hikariConfig.setMinimumIdle(5);
        // test Query
//        hikariConfig.setConnectionTestQuery("SELECT sysdate FROM dual");
//        hikariConfig.setPoolName("springHikariCP");
//
//        hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
//        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "200");
//        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
//        hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }

}
