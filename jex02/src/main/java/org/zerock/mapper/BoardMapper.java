package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;

import java.util.List;

@Repository
public interface BoardMapper {

//    @Select("select * from tbl_board where bno > 0") // xml로 대체
    public List<BoardVO> getList();

    public void insert(BoardVO board);

    public void insertSelectKey(BoardVO board);

    public BoardVO read(Long bno);

    public int delete(Long bno);

    public int update(BoardVO board);
}
