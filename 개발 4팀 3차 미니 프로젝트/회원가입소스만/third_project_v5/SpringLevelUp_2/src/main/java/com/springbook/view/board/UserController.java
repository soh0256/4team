package com.springbook.view.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
@SessionAttributes("user")
public class UserController implements HttpSessionListener{//���� ���������� ����? �������̽� �����ΰ�..?

	@Autowired//�ݵ�� ���־�� ��ü ���Ե�, �߿�
	private UserService userService;//�ΰ��� �����ϱ� ����
	
	// ȸ������
	@RequestMapping(value = "/signUp.do", method = RequestMethod.GET)
	public String signUpView(UserVO vo) {

		System.out.println("ȸ������ ȭ������ �̵�");
			
		return "signUp.jsp";
	}
		
	// HttpSession��ü�� �Ű������� ����
	@RequestMapping(value = "/signUp.do", method = RequestMethod.POST)
	public String signUp(UserVO vo) throws IOException{

		System.out.println("UserController�� signUp ȣ��");
			
		if(vo.getId() == null || vo.getId().equals("")) { 
			throw new IllegalArgumentException("���̵�� �ݵ�� �Է��ؾ� �մϴ�."); 
		}else if(vo.getPw() == null || vo.getPw().equals("")) { 
			throw new IllegalArgumentException("��й�ȣ�� �ݵ�� �Է��ؾ� �մϴ�."); 
		}else if(vo.getName() == null || vo.getName().equals("")) { 
			throw new IllegalArgumentException("�̸��� �ݵ�� �Է��ؾ� �մϴ�."); 
		}
		
		MultipartFile uploadFile = vo.getUser_image();
		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:/" + fileName));
			System.out.println("�����̹������ε�ɰ��ΰ�");
		}
		
		userService.insertUser(vo);//�ΰ��� �����ϱ� ����(userDao.insertUser�� �ƴ϶�)
		
		return "login.jsp";
		
	}
	
	
	
	// ��ȣ ����
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String modifyView(UserVO vo) {

		System.out.println("ȸ�� ���� ���� ȭ������ �̵�");
			
		return "modify.jsp";
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		session.removeAttribute("id");
		session.invalidate();
	}
		
	// HttpSession��ü�� �Ű������� ����
	/*@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String modify(UserVO vo, UserDAO userDAO) {

		System.out.println("ȸ�� ���� ���� ó��");
			
		if(vo.getId() == null || vo.getId().equals("")) { 
			throw new IllegalArgumentException("���̵�� �ݵ�� �Է��ؾ� �մϴ�."); 
		}else if(vo.getPw() == null || vo.getPw().equals("")) { 
			throw new IllegalArgumentException("��й�ȣ�� �ݵ�� �Է��ؾ� �մϴ�."); 
		}
			
		userDAO.updateUser(vo);
			
		
		return "login.jsp";
		
	}*/
	

}
