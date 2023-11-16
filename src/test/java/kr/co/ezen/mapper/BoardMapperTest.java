package kr.co.ezen.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.ezen.entity.Board;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {

	@Autowired
	private BoardMapper boardMapper;
	
/*	@Test
	public void testgetList() {
		
		List<Board> li= boardMapper.getList();  
		
			for(Board b:li) {
			log.info(b);
		}
	} */
	
//	@Test
//	public void testInsert() {
//		//디비에 잘 삽입이 되어지는지 확인 -> 로그띄우기
//		Board b=new Board();
//		b.setMemberID("ezen01");
//		b.setTitle("스프링1");
//		b.setContent("스프링1글");
//		b.setWriter("관리자");
//		boardMapper.insert(b); //호출하여 게시물을 데이터베이스에 삽입합니다.
//		log.info(b);  //사용하여 로그 b에 객체의 정보를 출력합니다.
//		//인설트 메서드가 제대로 동작하는지 확인하는 용도로 사용함.
//	}
	
	   @Test
	   public void testInsert() {
	      Board b=new Board();
	      
	      b.setMemberID("ezen03");
	      b.setTitle("스프링3");
	      //b.setMemberID("ezen02");
	      //b.setTitle("스프링2");
	      //b.setMemberID("ezen01");
	      //b.setTitle("스프링1");
	      b.setContent("스프링1글");
	      b.setWriter("관리자");
	      //boardMapper.insert(b);
	      boardMapper.insertSelectKey(b);
	      log.info(b);
	   }

	
}
