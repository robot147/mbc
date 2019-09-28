package com.example.spring02.model.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring02.model.board.dto.BoardDTO;

@Repository // dato bean으로 등록
public class BoardDAOImpl implements BoardDAO {

	@Inject // 의존관계 주입
	SqlSession sqlSession;
	
	
	
	
	@Override 
	public void deleteFile(String fullName) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getAttach(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAttach(String fullName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAttach(String fullName, int bno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void create(BoardDTO dto) throws Exception {
		sqlSession.insert("board.insert", dto);
	}

	@Override
	public BoardDTO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub

	}

//	게시물 목록
	@Override
	public List<BoardDTO> listAll(int start, int end, String search_option, String keyword) throws Exception {
		Map<String,Object> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("board.listAll", map);
	}

	@Override
	public void increaseViewcnt(int bno) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
