package com.example.spring02.service.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring02.model.memo.dao.MemoDAO;
import com.example.spring02.model.memo.dto.MemoDTO;

@Service
public class MemoServiceImpl implements MemoService {
	
	@Inject
	MemoDAO memoDao; // 스프링에서 생성한 dao 객체가 연결됨

// ====================<메모리스트>====================
	@Override
	public List<MemoDTO> list() {
		return memoDao.list();
	}

// ====================<메모 작성>====================	
	// 둘다 사용가능
	@Override
	public void insert(MemoDTO dto) {

	}
	@Override
	public void insert(String writer, String memo) {
		memoDao.insert(writer, memo);
		
	}
// ====================<>====================
// ====================<>====================
	@Override
	public MemoDTO memo_view(int idx) {
		return null;
	}
// ====================<>====================
	@Override
	public void update(MemoDTO dto) {

	}
// ====================<>====================
	@Override
	public void delete(int idx) {

	}

}
