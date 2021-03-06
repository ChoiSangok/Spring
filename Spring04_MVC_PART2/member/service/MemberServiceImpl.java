package com.kh.welcome.member.model.service;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.welcome.member.model.dao.MemberDao;
import com.kh.welcome.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public int insertMember(Member member) {
		
		//사용자가 입력한 password 
		String password = member.getPassword();
		
		//password 암호화 , 매번 다른 방식으로 암호화가 진행
		password = passwordEncoder.encode(password);
		System.out.println("암호화 된 비밀번호 : " + password);
		
		member.setPassword(password);
		
		return memberDao.insertMember(member);
	}
	
	public Member selectMember(Map<String,Object> commandMap) {
		
		//사용자가 입력한 비밀번호
		String password = (String) commandMap.get("pw");
		//DB에 저장된 사용자 정보
		Member member = memberDao.selectMember(commandMap);
		
		//사용자가 입력한 비밀번호와 DB에 인코딩되어 저장된 비밀번호
		//가 같은지 확인
		if(passwordEncoder.matches(password, member.getPassword())) {
			return member;
		}else {
			return null;
		}
	}
	
	public int updateMember(Member member) {
		String password = member.getPassword();
		password = passwordEncoder.encode(password);
		member.setPassword(passwordEncoder.encode(password));
		return memberDao.updateMember(member);
	}
	
	public int updateMemberToLeave(String userId) {
		return memberDao.updateMemberToLeave(userId);
	}
	
	public int selectId(String userId) {
		return memberDao.selectId(userId);
	}
	
	public void mailSending(Member member, String urlPath) {
		
		String setfrom = "azimemory@naver.com";
		String tomail = member.getEmail();
		String title = "회원가입을 환영합니다.";
		String htmlBody=
			"<form "
			+ "action='http://"+urlPath+"/member/joinimple.do'"
			+" method='post'>"
			+ "<h3>회원가입을 환영합니다</h3>"
			+ "<input type='hidden' value='" 
					+ member.getUserId() 
					+ "' name='userId'>"
			+ "<input type='hidden' value='"
					+ member.getPassword()
					+"' name='password'>"
			+ "<input type='hidden' value='"
					+ member.getTell()
					+"' name='tell'>"
			+ "<input type='hidden' value='"
					+ member.getEmail()
					+"' name='email'>"
			+ "<button type='submit'>전송하기</button></form>";
		
		//에러발생을 위한 코드
		int errorNumber = 10/0;
		
		mailSender.send(new MimeMessagePreparator() {
			   public void prepare(MimeMessage mimeMessage) throws MessagingException {
			     MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			     //보내는 이
			     message.setFrom(setfrom);
			     //받는 이
			     message.setTo(tomail);
			     //메일 제목
			     message.setSubject(title);
			     //메일 내용
			     //두번째 boolean값은 html 여부 (true : html , false : text)
			     message.setText(htmlBody, true);
			   };
		});
	}
	
	public void mailSendingToLeave(Member member) {
		
		String setfrom = "azimemory@naver.com";
		String tomail = member.getEmail();
		String title = "안녕히 가세요.";
		String htmlBody = "<h1>안녕히 가세요.</h1>";
		
		mailSender.send(new MimeMessagePreparator() {
			   public void prepare(MimeMessage mimeMessage) throws MessagingException {
			     MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			     //보내는 이
			     message.setFrom(setfrom);
			     //받는 이
			     message.setTo(tomail);
			     //메일 제목
			     message.setSubject(title);
			     //메일 내용
			     //두번째 boolean값은 html 여부 (true : html , false : text)
			     message.setText(htmlBody, true);
			   };
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
