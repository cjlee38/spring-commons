package org.cjlee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages= {"org.cjlee.service", "org.cjlee.aop"})
@EnableAspectJAutoProxy
//@MapperScan(basePackages= {"org.cjlee.mapper"})
public class RootConfig {
//
//    @Bean
//    public DataSource dataSource() {
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
//        hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:XE");
//
//        hikariConfig.setUsername("book_ex");
//        hikariConfig.setPassword("book_ex");
//
//        hikariConfig.setMinimumIdle(5);
//        // test Query
////        hikariConfig.setConnectionTestQuery("SELECT sysdate FROM dual");
////        hikariConfig.setPoolName("springHikariCP");
////
////        hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
////        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "200");
////        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
////        hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");
//
//        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
//
//        return dataSource;
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(dataSource());
//        return (SqlSessionFactory) sqlSessionFactory.getObject();
//    }

}
