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

	
	// ȸ������
	@RequestMapping(value = "/signUp.do", method = RequestMethod.GET)
	public String signUpView(UserVO vo) {

		System.out.println("ȸ������ ȭ������ �̵�");
			
		return "signUp.jsp";
	}
		
	// HttpSession��ü�� �Ű������� ����
	@RequestMapping(value = "/signUp.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO) {

		System.out.println("ȸ������ ó��");
			
		if(vo.getId() == null || vo.getId().equals("")) { 
			throw new IllegalArgumentException("���̵�� �ݵ�� �Է��ؾ� �մϴ�."); 
		}else if(vo.getPw() == null || vo.getPw().equals("")) { 
			throw new IllegalArgumentException("��й�ȣ�� �ݵ�� �Է��ؾ� �մϴ�."); 
		}else if(vo.getName() == null || vo.getName().equals("")) { 
			throw new IllegalArgumentException("�̸��� �ݵ�� �Է��ؾ� �մϴ�."); 
		}
		
		userDAO.insertUser(vo);
		
		return "login.jsp";
		
	}
	
	
	// ��ȣ ����
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String modifyView(UserVO vo) {

		System.out.println("ȸ�� ���� ���� ȭ������ �̵�");
			
		return "modify.jsp";
	}
		
	// HttpSession��ü�� �Ű������� ����
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String modify(UserVO vo, UserDAO userDAO) {

		System.out.println("ȸ�� ���� ���� ó��");
			
		if(vo.getId() == null || vo.getId().equals("")) { 
			throw new IllegalArgumentException("���̵�� �ݵ�� �Է��ؾ� �մϴ�."); 
		}else if(vo.getPw() == null || vo.getPw().equals("")) { 
			throw new IllegalArgumentException("��й�ȣ�� �ݵ�� �Է��ؾ� �մϴ�."); 
		}
			
		userDAO.updateUser(vo);
			
		
		return "login.jsp";
		
	}
	// ȸ�� Ż��
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String deleteView(UserVO vo) {
		
		System.out.println("ȸ�� Ż�� ȭ������ �̵�");
		
		return "delete.jsp";
	}
	
	//HttpSession ��ü�� �Ű������� ����
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String delete(UserVO vo, UserDAO userDAO) {
		System.out.println("ȸ�� ���� ó��");
		
		userDAO.deleteUser(vo);
		
		return "login.jsp";
		
	}
	

}
