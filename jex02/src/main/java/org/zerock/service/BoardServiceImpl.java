package org.zerock.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import java.util.List;

@Log4j
@Service
//@RequiredArgsConstructor
//@NoArgsConstructor
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper mapper;

    @Override
    public void register(BoardVO board) {
        log.info("register ... " + board);

        mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(Long bno) {
        log.info("get ..." + bno);

        return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {
        log.info("modify ..." + board);

        return mapper.update(board) == 1;
    }

    @Override
    public boolean remove(Long bno) {
        log.info("remove ... " + bno);

        return mapper.delete(bno) == 1;
    }

    @Override
    public List<BoardVO> getList(Criteria criteria) {
        log.info("get list ...");
        return mapper.getListWithPaging(criteria);
    }
}
