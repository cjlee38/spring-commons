package org.zerock.sample;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log
public class SampleTest {

    @Autowired
    private Restaurant restaurant;

    @Test
    public void testExist() {
        // given
        // when
        assertNotNull(restaurant);
        // then

        log.info(restaurant.toString());
        log.info("--------------------");
        log.info(restaurant.getChef().toString());
    }
}