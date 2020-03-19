package com.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.web.domain.BoardEnty;
import com.spring.web.paging.BoardPaging;
import com.spring.web.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	

	
	
	
	//게시판기본컨트롤러
	@RequestMapping(value = "/", method = { RequestMethod.POST, RequestMethod.GET })
	public String index(Model model) {

		return boardIndex(model);
	}

	
	//게시판 기본 컨트롤러
	@RequestMapping(value = "/boardListView", method = { RequestMethod.POST, RequestMethod.GET })
	public String boardIndex(Model model) {

	//	List<BoardEnty> listBoard = boardService.getBoardList();
		List<BoardEnty> listBoard = boardService.getBoardList();

		
		int cnt=boardService.countHowMany();
		BoardPaging page=new BoardPaging(cnt);
		model.addAttribute("listBoard", listBoard);
		model.addAttribute("page",page);
		
		
		

		return "boardListView";
	}
	
	
	//게시글 보기 컨트롤러
	@RequestMapping(value = "/boardReadView", method = { RequestMethod.POST, RequestMethod.GET })
	public String ReadIndex(int bbsno,Model model) {				
		BoardEnty readBoard =  boardService.getBoardInfo(bbsno);
		model.addAttribute("readBoard", readBoard);

		return "boardReadView";
	}
	
	
	
	//게시글 작성 페이지 이동 컨트롤러
	@RequestMapping(value = "/boardWriteView", method = { RequestMethod.POST, RequestMethod.GET })
	public String GoToWritingPage(Model model) {				
		return "boardWriteView";
	}
	
	
	
	
	
	//데이터 등록 컨트롤러
	@RequestMapping(value = "/boardWrite", method = { RequestMethod.POST, RequestMethod.GET })
	public String InsertIndex(BoardEnty boardenty,Model model) {				
		boardService.insertBoardContent(boardenty);
		return "redirect:/boardListView";
	}
	
	
	
	
	//수정 페이지 이동 컨트롤러
	@RequestMapping(value = "/GotomdifyPage", method = { RequestMethod.POST, RequestMethod.GET })
	public String GoToModifyPage(int bbsno,Model model) {
		
		
		 BoardEnty modifyBoard= boardService.getBoardInfo(bbsno);
		 model.addAttribute("modifyBoard",modifyBoard);
		
		return "boardModify";
	}
	

	//데이터 수정 반영 컨트롤러
	@RequestMapping(value = "/boardModify", method = { RequestMethod.POST, RequestMethod.GET })
	public String ModifyIndex(BoardEnty boardenty,Model model) {				
		boardService.updateBoardContent(boardenty);
		return "redirect:/boardListView";
	}
	
	
	//게시글 삭제 컨트롤러
	@RequestMapping(value = "/boardDelete", method = { RequestMethod.POST, RequestMethod.GET })
	public String DeleteIndex(int bbsno,Model model) {
		BoardEnty boardenty =  boardService.getBoardInfo(bbsno);		
		boardService.deleteBoardContent(boardenty);
		return "redirect:/boardListView";
	}
	
	@RequestMapping(value="changePage",method = { RequestMethod.POST, RequestMethod.GET } )
	public String changePage(int count,Model model)
	{	
		
		List<BoardEnty> listBoard = boardService.getBoardList();
		BoardPaging page=new BoardPaging(count);
		model.addAttribute("listBoard", listBoard);
		model.addAttribute("page",page);
		return "redirect:/boardListView";
	}
	
	
	
	
	
	
}
