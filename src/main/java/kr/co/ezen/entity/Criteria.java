package kr.co.ezen.entity;

import lombok.Data;

@Data
public class Criteria {
	//자바빈역확은 엔티티클래스에 만듬
	private int page;   //현재 페이지번호
	private int perPageNum;  //한 페이지 에  보여줄 게시글 개수 

	//검색기능 변수 
	private String type;
	private String keyword;
	
	
	
	   public Criteria() {
		      this.page=1;
		      this.perPageNum=3; //10
		   }
	
	   //현재 페이지 게시글 시작번호
	   public int getPageStart() {
	      return (page-1)*perPageNum;   //1~10 1 
	                             //11~20 2 
	                             //21~30 3
	   }

	}