package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BbsDAO;

public class BbsDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int num = Integer.parseInt(request.getParameter("board_num"));
		String pass = request.getParameter("board_pass");

		System.out.println(num + ", " + pass);

		ActionForward forward = new ActionForward();
		BbsDAO dao = new BbsDAO();

		boolean usercheck = dao.passOk(num, pass);

		if (usercheck == false) {
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제할 권한이 없습니다.');");
			out.println("location.href='./bbsList.do';");
			out.println("</script>");
			out.close();
			return null;
		}
		boolean result = dao.bbsDelete(num);

		if (result == false) {
			System.out.println("삭제 실패");
			return null;
		}
		forward.setRedirect(true);
		forward.setPath("./bbsList.do");
		return forward;
	}
}
