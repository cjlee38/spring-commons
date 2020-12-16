package org.cjlee.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.cjlee.domain.Criteria;
import org.cjlee.domain.ReplyVO;

import java.util.List;

@Mapper
public interface ReplyMapper {

    public int insert(ReplyVO vo);

    public ReplyVO read(Long rno);

    public int delete(Long rno);

    public int update(ReplyVO vo);

    public List<ReplyVO> getListWithPaging(
            @Param("cri")Criteria criteria,
            @Param("bno") Long bno
            );

}
