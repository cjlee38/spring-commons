package org.cjlee.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.cjlee.domain.Criteria;
import org.cjlee.domain.ReplyVO;
import org.cjlee.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j
public class ReplyServiceImpl implements ReplyService {

    private final ReplyMapper mapper;

    @Override
    public int register(ReplyVO vo) {
        log.info("register/insert in service :: vo = " + vo);
        return mapper.insert(vo);
    }

    @Override
    public ReplyVO get(Long rno) {
        final ReplyVO vo = mapper.read(rno);
        log.info("get/read in service :: vo = " + vo);

        return vo;
    }

    @Override
    public int modify(ReplyVO vo) {
        log.info("modify/update in service :: vo = " + vo);
        return mapper.update(vo);
    }

    @Override
    public int remove(Long rno) {
        log.info("remove/delete in service :: rno = " + rno);
        return mapper.delete(rno);
    }

    @Override
    public List<ReplyVO> getList(Criteria criteria, Long bno) {
        log.info("getList of bno in service :: bno = " + bno);
        return mapper.getListWithPaging(criteria, bno);
    }
}
