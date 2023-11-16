package kr.co.ezen.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.ezen.entity.Board;
import kr.co.ezen.entity.Criteria;
import kr.co.ezen.entity.Member;
import kr.co.ezen.entity.PageCre;
import kr.co.ezen.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	//페이지 번호 클릭할때 ,수저으 삭제 , 답글 검색결과 유지 
	@Autowired //생성자 주입 어노테이션
	BoardService  boardService;
	
	@RequestMapping("/list")  //리퀘스트는 겟 포스트 다들어옴 
	public String getList(Model m, Criteria cri) { 
		//"list"라는 문자열에 담아 board/list.jsp로 뿌린다.
		List<Board> li=boardService.getList(cri);
		m.addAttribute("li",li); //담았당 리스트 제이에스피에서 출력하믄된다.
		
		PageCre pageCre=new PageCre();
		pageCre.setCri(cri);
		pageCre.setTotalCount(boardService.totalCount(cri));
		m.addAttribute("pageCre",pageCre); //페이징 처리하기 위해 list.jsp로 넘겨야한다
		
		return "board/list";
	}
	
	@GetMapping("/register")
	public String register(){
		return "board/register";
	}
	@PostMapping("/register")
	public String register(Board vo, RedirectAttributes rttr) {

//		register i= new 
//		
//		for(int i=1;i<=10;i++) {
//			rttr =boardService.get(i);
//					rttr.add(rttr);
//		} rttr.addAttribute("",);

		boardService.register(vo);//idx 를 보드리스트에 넘길것임 
		rttr.addFlashAttribute("result",vo.getIdx()); //플래쉬 한번비춘다. 일회성 세션임 ()번게시물이 등록되었습니다,
//		System.out.println(vo);  //Board(idx=8, memberID=ezen01, title=a, content=a, writer=이창표, indate=null, count=0, boGroup=7, boSequence=0, boLevel=0, boUsable=0)
	
		return "redirect:/board/list";  //글등록후 리스트 화면으로 강제이동 
	}
	@GetMapping("/get")
	public String get(@RequestParam("idx")int idx, Model mo, 
			@ModelAttribute("cri") Criteria cri) {
		Board vo=boardService.get(idx); //글번호기준으로 넣어주시고
		boardService.cntUpdate(idx);  //리스트에서 누를때 조회수가 올라가야하니까 겟에다가 적어야한다. ! 이건 조회수임 조회수 
		mo.addAttribute("vo",vo); //제목 내용 모로 가져와서 
		return "board/get"; 
	}
	@GetMapping("/modify")
	public String modify(@RequestParam("idx")int idx, Model mo,
			@ModelAttribute("cri") Criteria cri) {  //모델 어트리비트 가져오면 현제페이지 유지된다.,(1페이지로 돌아가지 않음 ) //글번호 기준으로 값가져옴  
		Board vo=boardService.get(idx);
		mo.addAttribute("vo",vo);
		return "board/modify";
	}
	@PostMapping("/modify")
	public String modify(Board vo, Criteria cri, RedirectAttributes rttr) {  //Criteria cri이걸 가져오고  rttr에 담는아야해서 필요 현재보고있는 페이지값    
		 boardService.modify(vo);
		 
		 rttr.addAttribute("page",cri.getPage());
		 rttr.addAttribute("perPageNum",cri.getPerPageNum());  //수정완료후 페이지 이동안하게 값을 가져온다.
			rttr.addAttribute("keyword",cri.getKeyword());
			rttr.addAttribute("type",cri.getType()); 
		 
		return "redirect:/board/list";  //글등록후 리스트 화면으로 강제이동 
	}
	@GetMapping("/remove")
	public String remove(int idx, Criteria cri, RedirectAttributes rttr) {
		boardService.remove(idx);
		
		 rttr.addAttribute("page",cri.getPage());
		 rttr.addAttribute("perPageNum",cri.getPerPageNum()); //page=2&oeroagenum=10 가져감
			rttr.addAttribute("keyword",cri.getKeyword());
			rttr.addAttribute("type",cri.getType());
		 
		 
		return "redirect:/board/list";
	}
	@GetMapping("/reply")
	public String reply(int idx, Model mo,
			@ModelAttribute("cri") Criteria cri) {  //답글에 대한 페이지값 가져감 
		
		Board vo=boardService.get(idx);
		mo.addAttribute("vo",vo);
		return "board/reply";
	}
	@PostMapping("/reply")
	public String reply(Board vo, Criteria cri, RedirectAttributes rttr) {  //담아야됨 rttr여기에 담음 
		boardService.replyPro(vo); //여기에서 답글이 저장되는거임  답글누르면 디비저장하는거
		 rttr.addAttribute("page",cri.getPage());
		 rttr.addAttribute("perPageNum",cri.getPerPageNum());
			rttr.addAttribute("keyword",cri.getKeyword());
			rttr.addAttribute("type",cri.getType()); 
		 
		return "redirect:/board/list";
	}
}


