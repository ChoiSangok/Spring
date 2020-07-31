package com.kh.welcome.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.welcome.member.model.dto.Member;
import com.kh.welcome.member.model.service.MemberService;

@Controller
//Controller 어노테이션으로 해당 객체를 WebApplicationContext에 등록
// Controller 어노테이션을 등록함으로써 @RequestParam, @RequestMapping
// 같은 Controller를 위한 어노테이션을 사용할 수 있다.
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
//	@RequestMapping("/member/join.do")
//	//해당 메소드를 어떤 url에 매핑 시킬 지 설정
//	//value 속성에 url를 지정할 수 있다. 단 지정할 속성이 value밖에 없다면 생략 가능하다
//	
//	public void join() {
//		//void : 컨트롤러에서 return type이 void라면 요청온 url과 동일한 
//		//		 jsp를 찾아서 사용자에게 보내준다.
//		
		

	/**
	 * RequestMapping을 class에 적용하면 해당 클래스의 모든 메소드에 적용되는
	 * url를 지정할 수 있다.
	 * 이 url은 메소드에 붙는 url 의 앞 경로를 의미
	 */
//	@RequestMapping("/join.do")
//	public String join() {
////		String이 반환형이면 String으로 반환되는 문자열이 jsp 의 경로가 된다
//		
//		return "/member/join";
//	}
	@RequestMapping(value="/join",method = RequestMethod.GET)
	//만약 method 속성을 작성하지 않으면 get, post 둘 다 허용한다
	//value에 url, method속성에 허가할 http method 방식지정
	public ModelAndView join() {
		/**
		 * ModelAndView : model 객체에 값을 담고
		 * 				  viewName 을 보내고싶은 
		 * 		jsp의 경로로 지정
		 */
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/join");
		return mav;
		
	}
	
//	@RequestMapping(value="/login.do", method=RequestMethod.GET)
//	public ModelAndView login() {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/member/login");
//		return mav;
//		
//	}
	
	@RequestMapping("/login")
	public void login() { }
	
	
	/**
	 * @RequestParam :
	 * 		http 요청 파라미터를 컨트롤러 메소드의 파라미터로 전달 받을 때 사용한다.
	 *  타입을 자동으로 변환해줌(매개변수의 타입을 int로 지정했다면, String 을 int로 변환 )
	 *  단, 변경이 불가능한 경우에는 400 코드 에러 반환
	 *  
	 *  스프링 컨트롤러 매개변수 매핑 Case
	 *  메소드 매개변수와 HTML 태그의 Name 값이 같은 경우
	 *  dto 의 필드변수명과 HTML 태그의 Name 값이 같은 경우(@ModelAttribute)
	 *  메소드 매개변수에 Map을 지정한 경우  --> HTML 태그의 Name 값이 Map의 Key 값으로 저장
	 *  						 --> 단 @RequestParam 어노테이션이 명시적으로 지정되어있어야 한다.
	 *  
	 *  HttpServletRequest,
	 *  HttpServletResponse
	 *  HttpSession 를 매개변수로 지정할 경우
	 *  DisptcherServlet 이 해당 객체를 전달해준다.
	 *  
	 */
		
	/**
	 * @ModelAttribute
	 * @RequestParam Map<String, Object> member
	 */
	
	
	
	
	@RequestMapping("/joinimple")
	public ModelAndView joinImpl(

		HttpServletRequest req,
		@ModelAttribute Member member
//		@RequestParam Map<String,Object> commandMap
				) {
		
		String root = req.getContextPath();
		ModelAndView mav = new ModelAndView();
		
		int res = memberService.insertMember(member);
		if(res > 0) {
			mav.addObject("alertMsg", "회원가입성공!");
			mav.addObject("url", "/member/login");
			mav.setViewName("/common/result");
		} else {
			mav.addObject("alertMsg", "회원가입에 실패");
			mav.addObject("url", root+"/member/join");
			mav.setViewName("/common/result");
		}
		
		System.out.println(member);
		
		return mav;
	}
	
	@RequestMapping("/loginimple")
	public ModelAndView loginImpl(
			@RequestParam Map<String,Object> commandMap,
			HttpSession session,
			HttpServletRequest request
			) {
		ModelAndView mav = new ModelAndView();
		Member res = memberService.selectMember(commandMap);
		
		if(res != null) {
			session.setAttribute("logInInfo", res);
			mav.addObject("alertMsg", "로그인성공!");
			mav.addObject("url",request.getContextPath()+"/member/mypage");
			mav.setViewName("common/result");
		} else {
			mav.addObject("alertMsg", "로그인실패!");
			mav.addObject("url", request.getContextPath()+"/member/login");
		}

		return mav;

	}
	
	@RequestMapping("/mypage")
	public void mypage() {}
	
//	회원수정
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String mypageImpl(
			HttpServletRequest req,HttpSession session,
			@ModelAttribute Member member) {
		
		int res = memberService.updateMember(member);

		if(res > 0) {
			session.setAttribute("logInInfo", member);
			return "/member/mypage"; 
			
		} else {
			return "/member/mypage"; 
		}

	}
	
//	회원수정 강사님코드
//	@RequestMapping("/modify.do")
//	   public String modify(
//	         Member member
//	         ,HttpSession session
//	         ,Model model) {
//	      
//	      Member sessionMember 
//	      = (Member) session.getAttribute("logInInfo");
//	      
//	      member.setUserId(sessionMember.getUserId());
//	      int res = memberService.updateMember(member);
//	      
//	      if(res > 0) {
//	         model.addAttribute("alertMsg"
//	               , "회원정보수정이 성공했습니다.");
//	         model.addAttribute("url", "mypage.do");
//	         
//	         sessionMember.setPassword(member.getPassword());
//	         sessionMember.setEmail(member.getEmail());
//	         sessionMember.setTell(member.getTell());
//	      }else {
//	         model.addAttribute("alertMsg"
//	               , "회원정보수정에 실패하였습니다.");
//	         model.addAttribute("url", "mypage.do");
//	      }
//	      
//	      return "common/result";
//	   }
	   
	
	@RequestMapping(value="/leave", method=RequestMethod.POST)
	public String deleteImpl(
			HttpServletRequest req,HttpSession session,
			@ModelAttribute Member member) {
		
		int res = memberService.deleteMember(member);

		if(res > 0) {
			
			return "/member/login"; 
			
		} else {
			return "/member/mypage"; 
		}

	}
	
	@RequestMapping("/idcheck.do")
	@ResponseBody
	/**
	 * 메소드에 @ResponseBody 어노테이션을 지정하면
	 * 메소드에서 리턴하는 값을 viewResolover 를 거쳐서 출력하지 않고
	 * Http Response Body 에 직접 쓰게 된다
	 */
	public String idCheck(String userId){
		
		System.out.println(userId);
		System.out.println("idCheck메소드가 호출되었습니다");
		
		int res = memberService.selectId(userId);
		if(res > 0) {
			return userId;
			
		}
		return "";
	}
	
	@RequestMapping("joinemailcheck.do")
	public ModelAndView joinemailcheck(
			Member member
			, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		String urlPath = request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		
		memberService.mailSending(member, urlPath);
		
		mav.addObject("alertMsg", "이메일로 확인 메일이 발송되었습니다");
		mav.addObject("url", "login");
		mav.setViewName("common/result");

		
		return mav;
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
