package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BbsDAO;
import board.model.BbsDTO;

public class BbsUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		BbsDAO dao = new BbsDAO();
		BbsDTO data = new BbsDTO();
		ActionForward forward = new ActionForward();

		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String board_pass = request.getParameter("board_pass");

		boolean usercheck = dao.passOk(board_num, board_pass);
		if (usercheck == false) {
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("location.href='./bbsList.do';");
			out.println("</script>");
			out.close();
			return null;
		}

		data.setBoard_num(board_num);
		data.setBoard_subject(request.getParameter("board_subject"));
		data.setBoard_content(request.getParameter("board_content"));

		System.out.println("수정 보드넘 " + board_num);

		boolean result = dao.bbsUpdate(data);

		forward.setRedirect(true);
		forward.setPath("./bbsView.do?num=" + board_num);
		return forward;
	}

}
