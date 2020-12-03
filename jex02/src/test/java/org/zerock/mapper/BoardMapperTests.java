package org.zerock.mapper;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.zerock.config.RootConfig.class})
@Log4j
public class BoardMapperTests {

    @Autowired
    private BoardMapper mapper;

    @Test
    public void testGetList() {
        mapper.getList().forEach(log::info);
    }

    @Test
    public void testInsert() {
        // given
        BoardVO board = new BoardVO();
        board.setTitle("new title");
        board.setContent("new content");
        board.setWriter("newbie");
        // when

        mapper.insert(board);

        // then

        log.info(board);
    }

    @Test
    public void testInsertSelectKey() {
        // given
        BoardVO board = new BoardVO();
        board.setTitle("new title from selectkey");
        board.setContent("new content from selectkey");
        board.setWriter("newbie from selectkey");
        // when

        mapper.insertSelectKey(board);
        // then

        log.info(board);

    }

    @Test
    public void testRead() {
        BoardVO board = mapper.read(5L);

        log.info(board);

    }

    @Test
    public void testDelete() {
        int count = mapper.delete(3L);
        log.info("DELETE COUNT = " + count);
    }

    @Test
    public void testUpdate() {
        BoardVO board = new BoardVO();
        board.setBno(5L);
        board.setTitle("수정제목");
        board.setContent("수정내용");
        board.setWriter("user99");

        int count = mapper.update(board);
        log.info("UPDATE COUNT = " + count);
    }
}
