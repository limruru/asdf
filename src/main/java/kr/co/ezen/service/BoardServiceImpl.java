package kr.co.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ezen.entity.Board;
import kr.co.ezen.entity.Criteria;
import kr.co.ezen.entity.Member;
import kr.co.ezen.mapper.BoardMapper;
   // 내장 국밥만들기, 순대 국밥만들기 , .... 그런것들이다!!
@Service 
public class BoardServiceImpl implements BoardService { //보드서비스를 구현한 크랠스이며
//implements의 가장 큰 특징은 이렇게 부모의 메소드를 반드시 오버라이딩(재정의)해야 한다. 또한 이 implements는 다중상속을 대신해준다.
	@Autowired //스프링 컨테이너에 등록한 빈에게 의존관계 주입이 필요할때 의존성주입 어노테이션  /생성자, 수정자(setter), 필드 
	BoardMapper boardMapper;
	
	

	@Override
	public List<Board> getList(Criteria cri) {
		List<Board> li=boardMapper.getList(cri); //xml 쿼리문 실행
		return li;
	}

	
	@Override
	public Member login(Member vo) {
		
		Member mem=boardMapper.login(vo);
		return mem;
	}

	@Override
	public void register(Board vo) {
		boardMapper.insertSelectKey(vo);  //답글때문에 인설트가아닌 인설트 셀렉트키 사용. 동적에스엠엘
	}

	@Override
	public Board get(int idx) {
		Board vo=boardMapper.read(idx);
		return vo;  
	}//리스트 불러오기 제목클릭했을ㄸ ㅐ 메퍼 서비스 아이엠피엘 보드메퍼 호출 아이디엣스 기준으로 가져오기컨트롤러 작업...

	@Override
	public void modify(Board vo) {   //무얼수정할거인지의 내용 이있는거입 !!!!!
		boardMapper.update(vo);  //쿼리문실행됨 
		
	}

	@Override
	public void remove(int idx) {
		boardMapper.delete(idx);  //아이디엑스 기준으로 삭제 
	}
	@Override
	public void replyPro(Board vo) {
		//답글만들기 
		//부모글의 정보를 가져온다.
		Board pa=boardMapper.read(vo.getIdx()); //원글에 대한 글번호
		//부모그르이 비오그룹 값을 -> 답글정보에 저장 
		vo.setBoGroup(pa.getBoGroup());  //vo에 비오그룹을 셋팅합니다. (답글정보저장)
		
		vo.setBoSequence(pa.getBoSequence()+1); //부모글에 비오시퀀스의 값에 1을 더해서 ->답글정보에저장
		
		vo.setBoLevel(pa.getBoLevel()+1); //부모글에 비오레벨값에 1을더해서 ->답글 정보에 저장
		
		boardMapper.replyUpdate(pa);
		
		boardMapper.replyInsert(vo);//답글 저장
		
	}

	@Override
	public int totalCount(Criteria cri) {
		return boardMapper.totalCount(cri);
	}


	@Override
	public void cntUpdate(int idx) {
		boardMapper.cntUpdate(idx);
	}






}

