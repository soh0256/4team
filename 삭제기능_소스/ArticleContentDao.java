package article.dao;
/*article테이블의 데이터 삽입 기능 제공 : ArticleDao 
 article_content 테이블에 데이터 삽입 기능 제공: ArticleContentDao
ArticleDao, ArticleContentDao 와 연결되어 새로운 게시글 쓰기 기능을 제공하는 클래스: WriteArticleSerice클래스*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import article.model.ArticleContent;
import jdbc.JdbcUtil;

public class ArticleContentDao {
	
	private static ArticleContentDao content = new ArticleContentDao();
	public static ArticleContentDao getInstance() {
		return content;
	}
	
	public ArticleContent insert(Connection conn, ArticleContent  content) throws SQLException{
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(//article 데이터베이스에 article_content테이블
					"insert into article_content " + 
					"(article_no, content) values(?,?)");
			pstmt.setLong(1, content.getNumber());
			pstmt.setString(2, content.getContent());
			int insertedCount = pstmt.executeUpdate();
			/*insert 쿼리 실행에 성공하면 파라미터로 전달받은 content 객체를 그대로 리턴하고 아니면 null 리턴*/
			if(insertedCount>0) {
				return content;
			}else {
				return null;
			}
		}finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public ArticleContent selectById(Connection conn, int no)throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(
					"select * from article_content where article_no = ?");
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			ArticleContent content=null;
			if(rs.next()) {
				content=new ArticleContent(rs.getInt("article_no"), rs.getString("content"));
			}
			return content;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public int update(Connection conn, int no, String content) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update article_content set content = ? "+
						"where article_no = ?")) {
			pstmt.setString(1, content);
			pstmt.setInt(2, no);
			return pstmt.executeUpdate();
		}
	}
	
	public int delete(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("delete from article_content where article_no = ?");
			pstmt.setInt(1,no);
			return pstmt.executeUpdate();
		}finally {
			JdbcUtil.close(pstmt);
		}
		
	}

}
