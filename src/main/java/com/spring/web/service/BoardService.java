package com.spring.web.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.domain.BoardEnty;
import com.spring.web.mapper.BoardMapper;

@Service
public class BoardService {
    
    @Autowired
    BoardMapper boardMapper;
    
	/*
	 * public List<BoardEnty> getBoardList(){
	 * 
	 * return boardMapper.getBoardList(); }
	 */
    
    
    public List<BoardEnty> getBoardList(){
        
        return boardMapper.getPageBoardList();
    }
    
    public BoardEnty getBoardInfo(@Param("bbsno") int bbsno) {
    	return boardMapper.getBoardInfo(bbsno);
    }
    
    
    public int insertBoardContent(BoardEnty boardEnty) {    	
    	return boardMapper.insertBoardContent(boardEnty);
    }
    
    public int updateBoardContent(BoardEnty boardEnty)
    {
    	return boardMapper.updateBoardContent(boardEnty);
    }   
    
    
    public int deleteBoardContent(BoardEnty boardEnty)
    {
    	return boardMapper.deleteBoardContent(boardEnty);
    }   

    public int countHowMany()
    {
    	return (int)boardMapper.countHowMany();
    }
    
}
