package reply.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReplyDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs = null;

	public ReplyDAO() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			/*
			String url = "jdbc:mysql://127.0.0.1:3306/mydb";
			String user = "root";
			String password = "1234";
			*/
			String url = "jdbc:mysql://www.earlyview.co.kr:3306/mydb";
			String user = "chardin";
			String password = "1234";

			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean replyInsert(ReplyDTO data){
		
		boolean result = false;
		
		System.out.println("reply_num="+data.getReply_num()+", reply_board_num="+data.getReply_board_num()+", reply_name="+data.getReply_name());
		String sql = "insert into reply values (?, ?, ?, ?)";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data.getReply_num());
			pstmt.setString(2, data.getReply_board_num());
			pstmt.setString(3, data.getReply_name());
			pstmt.setString(4, data.getReply_content());
//			pstmt.setString(5, data.getReply_date());
			
			int cnt = pstmt.executeUpdate();
			System.out.println("cnt=" + cnt);
			if (cnt > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
			
		}
		return result;
	}
	
	public ArrayList<ReplyDTO> replyList(int num){
		
		ArrayList<ReplyDTO> replyList = new ArrayList<ReplyDTO>();
		
		String sql = "select * from reply reply_board_num = ?";
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				ReplyDTO reData = new ReplyDTO();
				
				reData.setReply_num("reply_num");
				reData.setReply_name("reply_name");
				reData.setReply_content("reply_content");
				
				replyList.add(reData);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			disconnect();
		}
		return replyList;
	}
	
	private void disconnect() {

		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
