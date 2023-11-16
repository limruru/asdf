package kr.co.ezen.mapper;

import java.util.List;

import kr.co.ezen.entity.Board;
import kr.co.ezen.entity.Criteria;
import kr.co.ezen.entity.Member;

public interface BoardMapper {

	public List<Board> getList(Criteria cri); //메서드는 List<Board> 형태의 결과를 반환하는 것임다게시판 객체의 리스트반환다흫 역할 수행 메서드 
	public void insert(Board vo);  //public void insert(Board vo); Board 객체를 인자로 받아 해당 객체를 삽입하는 역할  
									//이메서드는 새로운 게시물을 데이터베이스에 추가하는 등의 기능을 구현할 수있습니다.
	public void insertSelectKey(Board vo);  //글등록키 
	public Member login(Member vo);
	public Board read(int idx);
	public void update(Board vo);
	public void delete(int idx);
	public void replyUpdate(Board pa); //답글 저장하려고
	public void replyInsert(Board vo); //답글 저장? 
	//   반환형=리절트타입  매개변수=(파라미터타입)  어따가 삽일할건지 , 인트 ..기본형 스트링은 파라미터 생략  웨얼 조건절에 있움 
	public int totalCount(Criteria cri);
	public void cntUpdate(int idx);
//	public void modify(Board vo);
	
}
