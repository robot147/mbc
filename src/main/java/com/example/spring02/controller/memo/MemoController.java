package com.example.spring02.controller.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.memo.dto.MemoDTO;
import com.example.spring02.service.memo.MemoService;

@Controller // 현재 클래스를 컨트롤러 bean으로 등록
@RequestMapping("/memo/*")
public class MemoController {
	
	
	
//	테이블
//	create table board(
//			bno number not null, 
//			title varchar2(200) not null,
//			content varchar2(4000),
//			writer varchar2(50) not null,
//			regdate date default sysdate,
//			viewcnt number default 0,
//			primary key(bno)
//			);
	

//	@Controller				// 컨트롤러 bean(객체)으로 등록
//	@Service				// Service bean(객체)으로 등록
//	@Repository 			// dao bean(객체)으로 등록
//	
//	@Inject == @Autowired 	// 의존관계 주입(개발자가 직접X spring에서 자동으로 만들어줌)
//	
//	@RequestMapping			// url mapping
//	@RequestParam			// get,post방식의 개별변수 갖(넘어온 개별 변수)
//	@ModelAttribute			// dto로 전체 묶어서 넘오온 data
//	@ResponseBody			//컨트롤러에서 어떤 메소드를 호출한 다음 page로 넘기는게 아니라 date자체를 넘길때 ex) 제이슨
	
	
// =========================<메모 리스트들 보기>=========================
	@Inject // 의존관계 주입
	MemoService memoService; // 스프링이 만든 서비스 객체가 연결됨
	
	@RequestMapping("list.do")
	public ModelAndView list (ModelAndView mav) {
		List<MemoDTO> items = memoService.list(); // 메모 리스트 리턴
		mav.setViewName("memo/memo_list");// 출력 페이지의 이름
		mav.addObject("list", items); //출력 페이지에 전달할 변수
		System.out.println("ㅇㅇmav => "+mav);
		System.out.println("ㅇㅇitems  => "+items);
		return mav; //페이지로 이동
	}
	
	
// =========================<메모 작성>=========================
	@RequestMapping("insert.do") 
	public String insert(@ModelAttribute MemoDTO dto) {
		
		System.out.println("ㅇㅇdto.getWriter() => "+ dto.getWriter());
		System.out.println("ㅇㅇdto.getMemo() => "+ dto.getMemo());
		
		memoService.insert(dto.getWriter(), dto.getMemo() );
		return "redirect:/memo/list.do";
	}
	
	
// =========================<>=========================
// =========================<>=========================
// =========================<>=========================
// =========================<>=========================
// =========================<>=========================
// =========================<>=========================
// =========================<>=========================
// =========================<>=========================
// =========================<>=========================
// =========================<>=========================
// =========================<>=========================

	
	
}
