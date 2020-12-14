package org.cjlee.service;

import org.cjlee.domain.Criteria;
import org.cjlee.domain.ReplyVO;

import java.util.List;

public interface ReplyService {

    public int register(ReplyVO vo);

    public ReplyVO get(Long rno);

    public int modify(ReplyVO vo);

    public int remove(Long rno);

    public List<ReplyVO> getList(Criteria criteria, Long bno);
}
