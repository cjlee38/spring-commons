package org.cjlee.mapper;

import lombok.extern.log4j.Log4j;
import org.cjlee.domain.Criteria;
import org.cjlee.domain.ReplyVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.cjlee.config.RootConfig.class})
@Log4j
public class ReplyMapperTest {

    @Autowired
    private ReplyMapper mapper;

    // 491549
    private Long[] bnoArr = {491549L, 491548L, 491547L, 491546L, 491545L};

    @Test
    public void testMapper() {
        log.info(mapper);
    }

    @Test
    public void testCreadate() {
        IntStream.rangeClosed(1, 10).forEach((int i) -> {
            ReplyVO vo = new ReplyVO();
            vo.setBno(bnoArr[i % 5]);
            vo.setReply("댓글 테스트 " + i);
            vo.setReplyer("replyer" + i);

            mapper.insert(vo);
        });
    }

    @Test
    public void testRead() {
        Long rno = 21L;
        ReplyVO vo = mapper.read(rno);

        log.info(vo);
    }

    @Test
    public void testDelete() {
        Long rno = 21L;
        mapper.delete(rno);
    }

    @Test
    public void testUpdate() {
        Long rno = 22L;

        ReplyVO vo = mapper.read(rno);
        vo.setReply("Updated !! ");

        int count = mapper.update(vo);
        log.info("UDPATE COUNT = " + count);
    }

    @Test
    public void testList() {
        Criteria criteria = new Criteria();
        List<ReplyVO> replies = mapper.getListWithPaging(criteria, bnoArr[0]);

        replies.forEach((ReplyVO reply) -> log.info(reply));
    }


}