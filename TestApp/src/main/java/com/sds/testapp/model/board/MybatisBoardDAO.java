package com.sds.testapp.model.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sds.testapp.domain.Board;

@Mapper
public interface MybatisBoardDAO {
	public List selectBySearch(String title);
	public List selectAll(Map map);
	public Board select(int board_idx);
	public int getTotalCount();
	public int insert(Board board); //int로 하는 이유는? SqlSessionTemplate를 사용하지 않기 때문에 int 반환
	public int update(Board board);
	public int delete(Board board);
	
}
