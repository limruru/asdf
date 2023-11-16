package kr.co.ezen.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.ezen.entity.Board;
import kr.co.ezen.entity.Criteria;
import kr.co.ezen.mapper.DataSourceTest;
import lombok.extern.log4j.Log4j;

//@ContextConfiguration 만약 스프링 컨테이너가 필요 없다면, 즉, 스프링 빈 팩토리에서 빈을 로드하는 것이 아닌, 
//직접 new로 객체를 생성해가며 테스트 코드를 작성할 것이라면 위의 어노테이션을 제거해도 된다.


// JUnit 테스트에 스프링 컨테이너를 사용할거면 아래 세개의  어노테이션을 넣어주자.
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)   // 이 클래스는 내부적으로 스프링 컨테이너를 생성해준다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") 
public class BoardServiceTest {
	
	@Autowired  //스프링 컨테이너에 등록한 빈에게 의존관계주입이 필요할 때, DI(의존성 주입)을 도와주는 어노테이션이다.
	BoardService boardService;   //	public List<Board> getList(); 이것이 필요해서 가져옴 ..
	
	@Test  //@Test 어노테이션을 메소드위에 선언하면 해당 메소드를 테스트 대상으로 지정할 수 있다.
	public void testgetList() {
		Criteria cri=new Criteria();
		cri.setPage(1);
		cri.setPerPageNum(10);
		boardService.getList(cri).forEach(b->log.info(b));
	}
	
	
}
