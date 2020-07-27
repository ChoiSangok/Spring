package com.kh.welcome.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.welcome.member.model.dto.Member;

@Controller
//Controller 어노테이션으로 해당 객체를 WebApplicationContext에 등록
// Controller 어노테이션을 등록함으로써 @RequestParam, @RequestMapping
// 같은 Controller를 위한 어노테이션을 사용할 수 있다.
@RequestMapping("member")
public class MemberController {
	
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
	@RequestMapping(value="/join.do",method = RequestMethod.GET)
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
	
	@RequestMapping("/joinimple")
	public ModelAndView joinImpl(
		/**
		 * @RequestParam :
		 * 		http 요청 파라미터를 컨트롤러 메소드의 파라미터로 전달 받을 때 사용한다.
		 *  타입을 자동으로 변환해줌(매개변수의 타입을 int로 지정했다면, String 을 int로 변환 )
		 *  단, 변경이 불가능한 경우에는 400 코드 에러 반환
		 */
			
		/**
		 * @ModelAttribute
		 * dto에 http 요청 파라미터를 전달할 때 사용하는 annotation
		 * html 태그의 name 속성값과 dto의 필드변수명이 일치해야 mapping 이 정상적으로 이루어진다	
		 */
		
		@ModelAttribute Member member
//		@RequestParam Map<String,Object> commandMap
				) {
		ModelAndView mav = new ModelAndView();
		System.out.println(member);
		mav.setViewName("/member/login");
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
