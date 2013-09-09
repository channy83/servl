package board.model;

import java.sql.*;

import javax.sql.*;

import board.action.PagingAction;
import sun.security.timestamp.TSRequest;

import java.util.*;

public class BbsDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs = null;

	public BbsDAO() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://www.earlyview.co.kr:3306/mydb";
			String user = "chardin";
			String password = "1234";
/*
			String url = "jdbc:mysql://127.0.0.1:3306/mydb";
			String user = "root";
			String password = "1234";
*/
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean bbsInsert(BbsDTO data) {

		boolean result = false;

		String sql = "insert into board values (?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, data.getBoard_num());
			pstmt.setString(2, data.getBoard_name());
			pstmt.setString(3, data.getBoard_pass());
			pstmt.setString(4, data.getBoard_subject());
			pstmt.setString(5, data.getBoard_content());
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

	public ArrayList<Object> bList(int currentPage) {

		return null;
	}

	public ArrayList<Object> bbsList(int currentPage) {

		int maxList = 5; // 한 페이지에 보여질 게시물 수
		int dividePage = 5; // 한 화면에 보여줄 페이지 수 
		int startNum = ((currentPage - 1) * maxList); // 글 목록 시작할 첫글 정렬 번호

		// ArrayList<BbsDTO> list = new ArrayList<BbsDTO>();
		ArrayList<Object> list = new ArrayList<Object>();
		ArrayList<BbsDTO> listBoard = new ArrayList<BbsDTO>();

		PagingAction paging = new PagingAction(currentPage, maxList, dividePage);

		list.add(paging); // index 0

		String sql = "select * from board order by board_num desc limit ?, ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, maxList);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BbsDTO data = new BbsDTO();

				data.setBoard_num(rs.getInt("board_num"));
				data.setBoard_name(rs.getString("board_name"));
				data.setBoard_subject(rs.getString("board_subject"));
				data.setBoard_content(rs.getString("board_content"));

				listBoard.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		list.add(listBoard); // index 2

		return list;

	}

	public BbsDTO bbsView(int num) {

		BbsDTO data = null;
		String sql = "select * from board where board_num=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				data = new BbsDTO();
				data.setBoard_num(rs.getInt("board_num"));
				data.setBoard_name(rs.getString("board_name"));
				data.setBoard_subject(rs.getString("board_subject"));
				data.setBoard_content(rs.getString("board_content"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return data;
	}

	public boolean bbsDelete(int num) {

		String sql = "delete from board where board_num=?";
		boolean del = false;

		try {
			System.out.println(sql + num);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			int cnt = pstmt.executeUpdate();
			System.out.println("cnt=" + cnt);
			if (cnt > 0) {
				del = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		System.out.println(del);
		return del;
	}

	public boolean bbsUpdate(BbsDTO data) {

		String sql = "update board set board_subject=?, board_content=? where board_num=?";
		boolean result = false;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data.getBoard_subject());
			pstmt.setString(2, data.getBoard_content());
			pstmt.setInt(3, data.getBoard_num());
			int cnt = pstmt.executeUpdate();
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

	public boolean passOk(int num, String pass) {

		String sql = "select board_pass from board where board_num=?";

		boolean result = false;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();
			rs.next();

			// System.out.println(rs.getString("board_pass"));

			if (pass.equals(rs.getString("board_pass"))) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result == false)
				disconnect();
		}
		System.out.println("�н����� Ȯ�� " + result);
		return result;
	}

	public int getListCount() {

		int cnt = 0;
		String sql = "select count(*) as listCount from board";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt("listCount");
				// System.out.println("����ī��Ʈ " + cnt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}

	// disconnect()
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
