package com.spring.web.paging;

public class BoardPaging {
	
	public int count;
	public int postPerPage; 	// 페이지 당 게시글
	public  static int BLOCK_SCALE=10;	//화면 당 페이지 수?
	
	private Integer page=1;	// 현제 페이지

	
	
	private int prevPage;	// 이전 페이지
	private int nextPage;	// 다음 페이지
	private int totPage;	// 전체 페이지
	private int totBlock;	// 전체 페이지 블록
	private int curBlock;	// 현 페이지 블록
	
	
	// 현제 페이지 블록
	private int prevBlock;	// 이전 페이지 블록
	private int nextBlock;	// 다음 페이지 블록
	
	
	//between #{start} and #{end}
	private int pageBegin;	//#{start}
	private int pageEnd;	//#{end}
	private int blockBegin;	// 현제 페이지에 시작번호
	private int blockEnd;	// 현제 페이지에 끝번호


	
	

	// 생성자
	public BoardPaging(int cnt) {
		count=cnt;
		blockBegin=(int)Math.ceil(cnt/10)-1;
		blockEnd=(int)Math.ceil(cnt/10);	//버튼 개수
		
		pageBegin=1;
		pageEnd=10;
		
		int postPerPage=10; 	// 페이지 당 게시글
		BLOCK_SCALE=10;	//화면 당 페이지 수?
		
		page=1;	// 현제 페이지
		//	select * from db where bbsno between 'a' and 'b'현재 페이지
		// 현재 페이지가 page 므로  a=1 b,10
	}

	


	public void setTotPage(int count) {	//count는 아마 총 게시글 일듯?
		curBlock=1;
		this.totPage=(int)Math.ceil(count*1.0/postPerPage);	// 총 페이지= [count*1.0/페이지 당 게시글]을 올림처리
		
		
		/*
		 * //between #{start} and #{end}에 입력될 값 게산 setPageRange();
		 * 
		 * // 블락 총 개수 계산 setTotBlock();
		 * 
		 * //페이지 블록의 시작,끝 번호 계산 setBlockRange();
		 */	
			
	}


	/*
	 * private void setTotBlock() {
	 * 
	 * }
	 * 
	 * 
	 * private void setBlockRange() { //페이지 블록의 시작,끝 번호 계산
	 * 
	 * 
	 * //현재 페이지에 몇번째 페이지 블록에 속하는지 계산
	 * curBlock=(int)Math.ceil((page-1)/BLOCK_SCALE)+1; // 현 페이지 블락=[(현 페이지-1)/ 한 블락
	 * 당 페이지 수]+1
	 * 
	 * 
	 * //현재 페이지 블록의 시작, 끝 번호 계산 blockBegin =(curBlock -1) * BLOCK_SCALE +1;
	 * blockEnd=blockBegin+BLOCK_SCALE-1;
	 * 
	 * //마지막 블록이 범위를 초과하지 않도록 처리 if(blockEnd > totPage) blockEnd=totPage; //[이전] 을
	 * 눌렸을 때 이동할 페이지 번호 prevPage=(curBlock==1)? 1:(curBlock-1)*BLOCK_SCALE; //[다음] 을
	 * 눌렸을 때 이동할 페이지 번호 nextPage=curBlock > totBlock ? (curBlock * BLOCK_SCALE) :
	 * (curBlock*BLOCK_SCALE)+1; if(nextPage >= totPage) nextPage = totPage; }
	 * 
	 * 
	 * private void setPageRange() { //between #{start} and #{end}에 입력될 값 게산 //where
	 * rn between #{start} and #{end}
	 * 
	 * 
	 * }
	 */
	
	
}
