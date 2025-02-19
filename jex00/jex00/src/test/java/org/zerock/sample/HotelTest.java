package org.zerock.sample;

import lombok.extern.java.Log;
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
public class HotelTest {

    @Autowired
    private Hotel hotel;

    @Test
    public void testExist() {
        // given

        // when
        assertNotNull(hotel);

        log.info(hotel.toString());
        log.info("----------------------");
        log.info(hotel.getChef().toString());

        // then

    }

}