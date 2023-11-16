package kr.co.ezen.controller;

import kr.co.ezen.entity.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ezen.service.BoardService;

@Controller
@RequestMapping("/login/*")  //어노테이션은 /login 경로를 가진 요청을 처리하기 위한 핸들러 메소드를 지정하는 데 사용됩니다
public class LoginController {
	
	@Autowired //생성자 주입 어노테이션 보드서비스에 있는 함수 호출해야하니까. 다오가 없다.> 메퍼 >서버> 컨트롤러 
	BoardService  boardService;
	
	@RequestMapping("/loginPro")
	public String login(Member vo, HttpSession session) {  //데이텊를 페이지가 넘어가도 유지하는거 !!!
		
		Member mem=boardService.login(vo);//id pw 가 같으면 회원정보 가 불러와서 
		if(mem!=null) {  //로그인 되었으면
			session.setAttribute("mem", mem);
		}
		return "redirect:/board/list"; //강제이동
	}
	@RequestMapping("/logoutPro")
	public String logout(HttpSession session) {
		session.invalidate();  //세션끊는... 무효화 로그아웃했으니까 
		return "redirect:/board/list"; 
		
	}
	
	
	
	
}
