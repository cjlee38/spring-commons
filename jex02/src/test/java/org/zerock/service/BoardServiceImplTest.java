package org.zerock.service;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = org.zerock.config.RootConfig.class)
@Log4j
public class BoardServiceImplTest {


    @Autowired
    private BoardService service;

    @Test
    public void testExist() {
        log.info(service);
        assertNotNull(service);
    }

    @Test
    public void testRegister() {
        // given
        BoardVO board = new BoardVO();
        board.setTitle("서비스 작성 제목");
        board.setContent("서비스 작성 내용");
        board.setWriter("fromService00");

        // when

        service.register(board);

        // then
        log.info("생성된 게시물 번호 = " + board.getBno());
    }

    @Test
    public void testGetList() {
        service.getList(new Criteria(2, 10)).forEach(board -> log.info(board));
    }


    @Test
    public void testGet() {
        log.info(service.get(1L));
    }

    @Test
    public void testDelete() {
        log.info("REMOVE RESULT = " + service.remove(2L));
    }

    @Test
    public void testUpdate() {

        BoardVO board = service.get(1L);

        if (board == null) return;

        board.setTitle("수정된 제목입니다");
        log.info("MODIFY RESULT = " + service.modify(board));
    }

}