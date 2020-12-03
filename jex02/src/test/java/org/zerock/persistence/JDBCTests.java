package org.zerock.persistence;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j
public class JDBCTests {

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {
        // given

        try (Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "book_ex",
                "book_ex"
        )) {
            log.info(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
