package org.cjlee.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.cjlee.domain.BoardVO;
import org.cjlee.domain.Criteria;

import java.util.List;

@Mapper
public interface BoardMapper {

//    @Select("select * from tbl_board where bno > 0") // xml로 대체
    public List<BoardVO> getList();

    public void insert(BoardVO board);

    public void insertSelectKey(BoardVO board);

    public BoardVO read(Long bno);

    public int delete(Long bno);

    public int update(BoardVO board);

    public List<BoardVO> getListWithPaging(Criteria criteria);
}
