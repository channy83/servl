package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BbsDAO;
import board.model.BbsDTO;

public class BbsUpdateView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int num = Integer.parseInt(request.getParameter("num"));

		ActionForward forward = new ActionForward();
		BbsDAO dao = new BbsDAO();
		BbsDTO data = new BbsDTO();
		data = dao.bbsView(num);
		if (data == null) {
			System.out.println("수정실패");
			return null;
		}

		request.setAttribute("data", data);
		forward.setRedirect(false);
		forward.setPath("./bbs/update.jsp");
		return forward;
	}

}
