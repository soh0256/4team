package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import com.mysql.cj.protocol.Resultset;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.Writer;
import auth.service.LoginFailException;
import auth.service.User;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;


public class DeleteArticleService {
	private static DeleteArticleService instance = new DeleteArticleService();
	
	public static DeleteArticleService getInstance() {
		return instance;
	}
	
	public DeleteArticleService() {
	}
	
	
	public void deleteArticle(int no, String password) {
		Connection conn = null;
		
		try {
			conn=ConnectionProvider.getConnection(); //메시지 삭제를 위해 서버에 연결
			conn.setAutoCommit(false);
			
			MemberDao memberDao = new MemberDao();
			ArticleDao article = new ArticleDao();
			ArticleContentDao content = new ArticleContentDao();
			String pwd = memberDao.selectByPwd(conn, password);//패스워드 확인하는 부분
				content.delete(conn, no);
				article.delete(conn, no);
				conn.commit();
		} catch (SQLException ex) { //그러나 제대로 위의 과정이 이루어지지 않았다면 롤백
			JdbcUtil.rollback(conn);
			throw new ServiceException("삭제 실패:" + ex.getMessage(), ex);
		}finally {//암튼 뭘 어떤 것을 해도 창은 닫야야 함
			JdbcUtil.close(conn);
		}
	}
	
}


