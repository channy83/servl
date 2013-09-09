package board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.model.ReplyDAO;
import reply.model.ReplyDTO;
import board.model.BbsDAO;
import board.model.BbsDTO;

public class BbsViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int num = Integer.parseInt(request.getParameter("num"));
		BbsDAO dao = new BbsDAO();
		BbsDTO data = dao.bbsView(num);

		ReplyDAO reDao = new ReplyDAO();
		ArrayList<ReplyDTO> replyList = reDao.replyList(num);

		if (data == null) {
			System.out.println("글보기 실패");
			return null;
		}
		request.setAttribute("data", data);
		request.setAttribute("replyList", replyList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./bbs/view.jsp");
		return forward;
	}

}
