package com.springbook.view.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class UserController {

	
	// 회원가입
	@RequestMapping(value = "/signUp.do", method = RequestMethod.GET)
	public String signUpView(UserVO vo) {

		System.out.println("회원가입 화면으로 이동");
			
		return "signUp.jsp";
	}
		
	// HttpSession객체를 매개변수로 받음
	@RequestMapping(value = "/signUp.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO) {

		System.out.println("회원가입 처리");
			
		if(vo.getId() == null || vo.getId().equals("")) { 
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다."); 
		}else if(vo.getPw() == null || vo.getPw().equals("")) { 
			throw new IllegalArgumentException("비밀번호는 반드시 입력해야 합니다."); 
		}else if(vo.getName() == null || vo.getName().equals("")) { 
			throw new IllegalArgumentException("이름은 반드시 입력해야 합니다."); 
		}
		
		userDAO.insertUser(vo);
		
		return "login.jsp";
		
	}
	
	
	// 암호 변경
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String modifyView(UserVO vo) {

		System.out.println("회원 정보 변경 화면으로 이동");
			
		return "modify.jsp";
	}
		
	// HttpSession객체를 매개변수로 받음
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String modify(UserVO vo, UserDAO userDAO) {

		System.out.println("회원 정보 변경 처리");
			
		if(vo.getId() == null || vo.getId().equals("")) { 
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다."); 
		}else if(vo.getPw() == null || vo.getPw().equals("")) { 
			throw new IllegalArgumentException("비밀번호는 반드시 입력해야 합니다."); 
		}
			
		userDAO.updateUser(vo);
			
		
		return "login.jsp";
		
	}
	// 회원 탈퇴
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String deleteView(UserVO vo) {
		
		System.out.println("회원 탈퇴 화면으로 이동");
		
		return "delete.jsp";
	}
	
	//HttpSession 객체를 매개변수로 받음
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String delete(UserVO vo, UserDAO userDAO) {
		System.out.println("회원 삭제 처리");
		
		userDAO.deleteUser(vo);
		
		return "login.jsp";
		
	}
	

}
