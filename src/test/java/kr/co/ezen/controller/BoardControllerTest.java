package kr.co.ezen.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import kr.co.ezen.mapper.BoardMapperTest;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //서블릿 컨텍스트를 사용하기 위해서 .. 컨트롤러가 거기이씅니까 .
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                     "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class BoardControllerTest {
   
   @Autowired
   private WebApplicationContext ctx; //스프링 컨테이너
   
   private MockMvc mockMvc; //가상의 mvc환경을 만든다//서버를 구동하지않고 확인하 가상의 엠브이씨 환경 클래스 목엠브이씨 목(속이다가짜)
   //(jsp만들고 톰캣구동하고 테스트 하기 불편 -> 가상mvc 환경 만든다 
   // -> 톰캣 구동하지 않고도 controller테스트 가능(가상으로 서버 만들어서)컨트롤러쪽에만 필요함.. 다른곳에는 필요없음 맵핑땜시 
   
   @Before //(테스트 메소드를 실행하기 전에 먼저 자동으로 실행해준다)
   public void setup() {
      this.mockMvc=MockMvcBuilders.webAppContextSetup(ctx).build(); //ctx빈들을 빌드해서 아래로.
   }
   
   @Test
   public void testList() throws Exception{
      log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")) //겟방식으로 가짜 유알엘에다가 셋팅하겠다. 
            .andReturn()//게시글 3개 리턴 
            .getModelAndView().getModelMap()); //모델값과 페이지..
   }
}




