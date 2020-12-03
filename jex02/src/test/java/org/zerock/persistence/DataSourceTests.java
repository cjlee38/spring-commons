package org.zerock.persistence;

import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class DataSourceTests {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testConnection() {
        try(Connection con = dataSource.getConnection()) {
            log.info(con);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testMybatis() {

        try (SqlSession session = sqlSessionFactory.openSession();
             Connection con = session.getConnection();
        ) {
            log.info(session);
            log.info(con);
            PreparedStatement statement = con.prepareStatement("SELECT * FROM tbl_board");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                log.info("resultSet.getString(2) = " + resultSet.getString(2));
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }


}
