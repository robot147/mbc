package com.example.spring02.model.memo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.spring02.model.memo.dto.MemoDTO;

public interface MemoDAO {
	
	
// =========================<메모 리스트 >=========================
	@Select("select * from memo order by idx desc")
	public List<MemoDTO> list();
	
// =========================<메모 작성>=========================
// insert into memo (idx, writer, memo) values ( (select nvl(max(idx)+1, 1) from memo), '박다빈', '집중하자' );
	
							// 글번호(idx), 작성자이름(writer), 메모내용(memo)
	//@Insert("insert into memo (idx, writer, memo)"			 // max(idx) => 글번호 최대값
	//		+"values ( (select nvl(max(idx)+1, 1) from memo)"// nvl => 값이 없을 때 ,ㅁ로 교체해주세요
	//		+",#{writer}, #{memo} )")
	@Insert("insert into memo (idx, writer, memo) values ( (select nvl(max(idx)+1, 1) from memo), #{writer}, #{memo} )")
	public void insert(@Param("writer") String writer, // 바로 위에 쿼리문에 #{ㅁㅁ}에 뭐가 들어가 갈지는 @Param으로 표현함
					   @Param("memo")   String memo
					   );
	
// =========================<>=========================
// =========================<>=========================
// =========================<>=========================
// =========================<>=========================
// =========================<>=========================
// =========================<>=========================
// =========================<>=========================
// =========================<>=========================
	
	
	
}
