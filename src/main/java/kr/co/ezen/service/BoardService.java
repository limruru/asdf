package kr.co.ezen.service;

import java.util.List;

import kr.co.ezen.entity.Board;
import kr.co.ezen.entity.Criteria;
import kr.co.ezen.entity.Member;

public interface BoardService { //보드서비스 인터페이스를 구현핟다. 보드다오 클래스는 독립적인 클래스로 구현되어야 하는 반면 보드서비스는 BoardServiceImpl.ja 이 구현한다.
	//추상화해놓은거   인터페이스가 어려우면   국밥만들기로 생각하자 !!
	//인터페이스는 선언만한다. ㄴ
	
	public List<Board> getList(Criteria cri);
	public Member login(Member vo); //mpl로감 
	public void register(Board vo);  //impl 
	public Board get(int idx); //게시글가져오기 
	public void modify(Board vo);   ///수정하거야만 선언해놓음 !!!!!
	public void remove(int idx); 
	public void replyPro(Board vo); 
	public int totalCount(Criteria cri); //전체 페이지수
	public void cntUpdate(int idx);
}
