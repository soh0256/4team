package article.dao;
/*article테이블과, article_content테이블에 데이터를 추가할 때 사용할 클래스
 데이터 삽입 기능을 제공함. 이후 이 클래스를 이용해여 WriterArticleService클래스가 
 새로운 게시글 쓰기 기능 제공*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import article.model.Article;
import article.model.Writer;
import article.dao.ArticleDao;
import article.dao.ArticleDao;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import oracle.net.aso.s;

public class ArticleDao {
	
	private static ArticleDao articleDao = new ArticleDao();
	public static ArticleDao getInstance() {
		return articleDao;
	}

		//데이터를 삽입하는 insert() 메서드
		public Article insert(Connection conn, Article article) throws SQLException{
			PreparedStatement pstmt=null;
			Statement stmt = null;
			ResultSet rs = null;
			try {//아래의 쿼리문에 article_no컬럼이 없는 이유는, 자동증가 칼럼이기 때문에 값을 지정하지 않아도 되기 때문
				pstmt=conn.prepareStatement("insert into article "
						+"(writer_id, writer_name, title, regdate, moddate, read_cnt) "
						+"values(?,?,?,?,?,0)");
			pstmt.setString(1, article.getWriter().getId());
			pstmt.setString(2, article.getWriter().getName());
			pstmt.setString(3, article.getTitle());
			pstmt.setTimestamp(4, toTimestamp(article.getRegDate()));
			pstmt.setTimestamp(5, toTimestamp(article.getModifiedDate()));
			int insertedCount = pstmt.executeUpdate();
			
			if(insertedCount >0) {
				stmt=conn.createStatement();
				rs=stmt.executeQuery("select last_insert_id() from article");
				//이 쿼리를 통해 article_no 칼럽의 값을 구함.
				if(rs.next()) {
					Integer newNum = rs.getInt(1);//
					return new Article(newNum, 
							article.getWriter(), 
							article.getTitle(), 
							article.getRegDate(), 
							article.getModifiedDate(), 
							0);
				}
			}
			return null;
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(stmt);
				JdbcUtil.close(pstmt);
			}
		}//public Article insert() 메서드의 끝

		private Timestamp toTimestamp(Date date) {
			return new Timestamp(date.getTime());
		}
		
		public int selectCount(Connection conn) throws SQLException{
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.createStatement();
				rs=stmt.executeQuery("select count(*) from article");
				if(rs.next()) {
					return rs.getInt(1);//현재 행의(읽어들인 행의) 첫번재 열의 값을 반환한다.
				}
				return 0;
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(stmt);
			}
		}
		
		public List<Article> select(Connection conn, int startRow, int size) throws SQLException {
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			
			try {
				pstmt=conn.prepareStatement("select * from article " + 
								"order by article_no desc limit ?,?");
				pstmt.setInt(1, startRow);/*읽어올 첫 번째 행의 번호를 입력한다
				다만, startRow에 들어갈 수는 0부터 세므로, 만약 4가 들어가면  0부터 시작해 4번째 부터 가져온다는 것이므로 
				0,1,2,3,4 즉 5행부터 가져온다는 뜻이다.*/
				pstmt.setInt(2, size);//읽어올 행의 개수
				rs=pstmt.executeQuery();
				List<Article> result = new ArrayList<Article>();
				while(rs.next()) {
					result.add(convertArticle(rs));
					//앞의 쿼리문 실행 후의 결과를 Article클래스의 객체로 생성하는 convertArticle(rs) 
				}
				return result;
			} finally {
				JdbcUtil.close(rs);
			}
		}
		//ResultSet에서 데이터를 읽어와서 Article 객체를 생성한다. 
		//ResultSet: 쿼리문 실행 후의 데이터베이스 결과값을 담고있다.
		private Article convertArticle(ResultSet rs) throws SQLException{
			return new Article(rs.getInt("article_no"), 
					new Writer(rs.getString("writer_id"), rs.getString("writer_name")), 
					rs.getString("title"), 
					toDate(rs.getTimestamp("regdate")), 
					toDate(rs.getTimestamp("moddate")), 
					rs.getInt("read_cnt"));
		}
		
		private Date toDate(Timestamp timestamp) {
			return new Date(timestamp.getTime());
		}
		
		public Article selectById(Connection conn, int no)throws SQLException{
			PreparedStatement pstmt= null;
			ResultSet rs = null;
			try {
				pstmt=conn.prepareStatement(
						"select * from article where article_no = ?");
				pstmt.setInt(1, no);
				rs=pstmt.executeQuery();
				Article article = null;
				if(rs.next()) {
					article=convertArticle(rs);
				}
				return article;
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
		
		public String selectPwdByNo(Connection conn, int no) throws SQLException{
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt=conn.prepareStatement("select writer_name from article where article_no = ?");
				pstmt.setInt(1, no);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					PreparedStatement pstmt2=null;
					ResultSet rs2 = null;
					pstmt2=conn.prepareStatement("select password from member where name = ? ");
					rs2=pstmt2.executeQuery();
					String pwd = rs2.getString("password");
					return pwd;
				}
			} catch (Exception e) {
				e.getMessage();
			}
			return null;
		}
		
		
		public void increaseReadCount(Connection conn, int no) throws SQLException{
			try(PreparedStatement pstmt=conn.prepareStatement(
					"update article set read_cnt = read_cnt + 1 "+//조회한 게시글의 조회수 1 증가
			"where article_no = ?")){/*그런데 조건이 있음, 
			매개변수로 받은 no. 즉 지정한 게시글의 번호에 해당하는 레코드에만 */
				pstmt.setInt(1, no);
				pstmt.executeUpdate();
			}
					
		}
		
		public int update(Connection conn, int no, String title) throws SQLException {
			try (PreparedStatement pstmt = 
					conn.prepareStatement(
							"update article set title = ?, moddate = now() "+
							"where article_no = ?")) {
				pstmt.setString(1, title);
				pstmt.setInt(2, no);
				return pstmt.executeUpdate();
			}
		}

		public int delete(Connection conn, int no) throws SQLException {
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement("delete from article where article_no = ?");
				pstmt.setInt(1, no);
				return pstmt.executeUpdate();
			}finally {
				JdbcUtil.close(pstmt);
			}
			
		}
		
}
