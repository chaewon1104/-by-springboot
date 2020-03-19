package com.spring.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.spring.web.domain.BoardEnty;

@Component
@Mapper
public interface BoardMapper {
    
    @Select("SELECT bbsno,wname,subject,to_char(regdt,'YYYY.MM.DD hh24:mm:ss') regdt FROM tb_bbs order by bbsno desc")
    public List<BoardEnty> getBoardList();
    
    @Select("SELECT bbsno,wname,subject,content,to_char(regdt,'YYYY.MM.DD hh24:mm:ss') regdt FROM tb_bbs WHERE bbsno = #{bbsno}")
    public BoardEnty getBoardInfo(@Param("bbsno") int bbsno);
    
    @Insert("INSERT INTO tb_bbs (bbsno, wname, subject, content, passwd, readcnt) VALUES(BBSNO_SEQ.NEXTVAL, #{wname}, #{subject}, #{content}, #{passwd}, #{readcnt})")
    public int insertBoardContent(BoardEnty boardEnty);
    
    @Update("UPDATE tb_bbs SET wname=#{wname}, subject=#{subject}, content=#{content} WHERE bbsno=#{bbsno}") 
    public int updateBoardContent(BoardEnty boardEnty);
    
    @Delete ("DELETE FROM tb_bbs WHERE bbsno=#{bbsno}") 
    public int deleteBoardContent(BoardEnty boardEnty);
    
    @Select	("SELECT COUNT(bbsno) FROM tb_bbs")
    public int countHowMany();
    
    @Select("SELECT "
    		+ ""
    		+ ""
    		+ ""
    		+ "bbsno,wname,subject,to_char(regdt,'YYYY.MM.DD hh24:mm:ss') regdt FROM tb_bbs where bbsno between 39 and 50 order by bbsno desc")
    public List<BoardEnty> getPageBoardList();
}
