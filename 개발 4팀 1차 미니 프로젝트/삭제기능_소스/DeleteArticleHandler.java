package article.command;
/*요청연결 방식이 get방식이라면(넘기는 값 필요 없을 경우) FORM_VIEW를 보여주는 메서드를  리턴하고 
요청연결 방식이 post방식이라면(넘기는 값이 필요한 경우), DELETE_VIEW를 보여주는 메서드를 리턴한다.*/
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleContentNotFoundException;
import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.DeleteArticleService;
import article.service.InvalidPasswordException;
import article.service.ModifyArticleService;
import article.service.ModifyRequest;
import article.service.PermissionDeniedException;
import article.service.ReadArticleService;
import auth.service.User;
import member.dao.MemberDao;
import mvc.command.CommandHandler;

public class DeleteArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/confirmDeletion.jsp";
	private static final String DELETE_VIEW = "/WEB-INF/view/deleteArticle.jsp";	

	private DeleteArticleService deleteService = new DeleteArticleService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req,res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res)
			throws IOException {	
		try {
			return FORM_VIEW;
		}catch (ArticleNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		User user = (User)req.getSession(false).getAttribute("authUser");
		String name = user.getName();
		
		int no = Integer.parseInt(req.getParameter("no").trim());
		String password = req.getParameter("password");
		boolean invalidPassword = false;
		try{
			DeleteArticleService deleteArticleService = DeleteArticleService.getInstance();
			deleteArticleService.deleteArticle(no, password);
			/*DeleteArticleService의 deleteArticle메서드 안에서 패스워드 확인 부분에서 패스워드 오류로 
			해당 부분에서 오류가 난다면 SQLException예외가 발생하고 삭제가 이루어지지 않는다.*/
			/*삭제가 이루어지지 않는다면 여기에서도 예외가 발생하게 되므로, catch로 점프*/
			/*만약 비밀번호가 맞다면 삭제가 정상적으로 이루어짐*/
			return DELETE_VIEW;
		} catch(InvalidPasswordException ex){
			invalidPassword = true;
			return "/WEB-INF/view/deleteFail.jsp";
		}
		
	}
}	
