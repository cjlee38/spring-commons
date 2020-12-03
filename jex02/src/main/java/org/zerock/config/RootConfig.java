package org.zerock.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.AdditionalDatabaseMetaData;
import oracle.jdbc.OracleType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "org.zerock.mapper")
@Log4j
public class RootConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE"); // 기존 db만 그냥 연결할때

        hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:XE");

        hikariConfig.setUsername("book_ex");
        hikariConfig.setPassword("book_ex");

        HikariDataSource source = new HikariDataSource(hikariConfig);
        return source;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource());
        return factory.getObject();
    }
}
