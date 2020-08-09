package com.kh.welcome.board.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {
	
	@RequestMapping("board/boardform.do")
	public String boardForm() {
		
		return "board/boardForm";
	}
	
	//추후에 수정 될 메소드
	@RequestMapping("/notice/noticeupload.do")
	public ModelAndView noticeUpload(
			/**
			 * 다중파일 업로드이므로
			 * 여러개의 MultipartFile 을 담기 위한 List생성
			 */
			@RequestParam List<MultipartFile> files
			,HttpSession session
			) {
		
			ModelAndView mav = new ModelAndView();
			String root = session.getServletContext().getRealPath("/");
			
			/**
			 * MultipartFile 예외처리
			 * 1. 사용자가 게시글만 작성하고 파일업로드를 하지 않을 경우
			 * 2. 사용자가 첨부한 파일이 없어도 List<MultipartFile> 의 size() 가 1로 잡힌다.
			 * 		이때 첨부한 파일의 이름은 공백이다.
			 */
			if(!(files.size() == 1 && files.get(0).getOriginalFilename().equals(""))) {
				
				for(MultipartFile mf :files) {
					//파일을 저장할 경로
					String savePath = root + "resources/upload";
					System.out.println(savePath);
					
					//transferTo 메소드의 매개변수에 넣어줄 빈 파일 객체를 저장할 경로 + 사용자가 등록한 파일 이름으로 생성
					File fileData = new File(savePath+"/"+mf.getOriginalFilename());
					
					try {
						//빈 파일 객체에 사용자가 등록한 파일을 덮어쓴다
						mf.transferTo(fileData);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			return mav;

	}
	

}

