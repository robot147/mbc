package com.example.spring02.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.board.dto.BoardDTO;
import com.example.spring02.service.board.BoardService;
import com.example.spring02.service.board.Pager;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	
	@Inject // 서버스 객체 주입
	BoardService boardService;
	
	
	
	@RequestMapping("write.do")
		public String write() {
		return "board/write"; 
	}
	
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute BoardDTO dto, HttpSession session) 
	throws Exception{
		
		// 로그인한 사용자의 아이디
		String writer= (String)session.getAttribute("userid");
		dto.setWriter(writer);
		   //레코드가 저장됨
		   boardService.create(dto);
		   //목록 갱신
		   return "redirect:/board/list.do";
		
	}
	
	
	@RequestMapping("list.do") 
	public ModelAndView list(
			@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="all") String search_option,
			@RequestParam(defaultValue="") String keyword
			) throws Exception {
		int count=1000; //레코드 갯수
		Pager pager=new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		List<BoardDTO> list=boardService.listAll(
				start, end, search_option, keyword);// 목록
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/list");// 이동할 페이지 지정
		Map<String, Object> map = new HashMap<>();
		map.put("list", list); // 맵에 자료 저장
		map.put("count", count);
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		map.put("pager", pager);
		mav.addObject("map", map); //데이터 저장
		return mav;// 페이지 이동(출력)
	}
}
