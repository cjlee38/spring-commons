package org.zerock.persistence;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = org.zerock.config.RootConfig.class)
@Log4j
public class TimeMapperTest {

    @Autowired
    private TimeMapper timeMapper; // 에러가 나지만 잘 실행되네

    @Test
    public void testGetTime() {
        log.info(timeMapper.getClass().getName());
        log.info(timeMapper.getTime());
    }

    @Test
    public void testGetTime2() {
        log.info("getTime2");
        log.info(timeMapper.getTime2());
    }
}
