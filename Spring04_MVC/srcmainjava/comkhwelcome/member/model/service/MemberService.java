package com.kh.welcome.member.model.service;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.kh.welcome.member.model.dao.MemberDao;
import com.kh.welcome.member.model.dto.Member;

/**
 * @Service : @Controller 나 @Repository 와 달리
 * bean으로 등록시켜주는 기능 외에는 별다른 기능이 없다
 * @Component와 동일 . 단 가독성을 위해 @Service 어노테이션을 사용한다
 */
@Service
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	JavaMailSender mailSender;
	
	
	//회원가입
	public int insertMember(Member member) {
		return memberDao.insertMember(member);
	}
	
	//map이용 선택
	public Member selectMember(Map<String,Object> commandMap) {
		return memberDao.selectMember(commandMap);
		
	}
	
//	회원수정
	public int updateMember(Member member) {
		return memberDao.updateMember(member);
		
	}
	
	//회원탈퇴
	public int deleteMember(Member member) {
		return memberDao.deleteMember(member);
		
	}
	
	//아이디중복체크
	public int selectId(String userId) {
	      return memberDao.selectId(userId);
	}
	
	//이메일
	public void mailSending(Member member, String urlPath) {
		
		String setfrom = "vnfmaghkdwp@naver.com";
		String tomail = member.getEmail();
		String title="회원가입을 환영합니다";
		String htmlBody = 
				"<form action='http://" + urlPath + "/member/joinimple'"
				+ "method='post'>"
				+ "<h3>회원가입을 환영합니다</h3>"
				+ "<input type='hidden' value='" + member.getUserId() + "'name='userId'>"
				+ "<input type='hidden' value='" + member.getPassword() + "'name='password'>"
				+ "<input type='hidden' value='" + member.getTell() + "'name='tell'>"
				+ "<input type='hidden' value='" + member.getEmail() + "'name='email'>"
				+ "<button type='submit'>전송하기</button></form>";		
		
		 mailSender.send(new MimeMessagePreparator() {
			   public void prepare(MimeMessage mimeMessage) throws MessagingException {
			     MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			     //보내는 이
			     message.setFrom(setfrom);
			     //받는이
			     message.setTo(tomail);
			     //메일 제목
			     message.setSubject(title);
			     //메일 내용
			     //두번재 boolean 값은 html 여부( true : html, false : text )
			     message.setText(htmlBody, true);
			   }
			 });
		
		
		
	}

}





