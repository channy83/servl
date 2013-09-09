package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BbsDAO;
import board.model.BbsDTO;

public class BbsWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		BbsDTO data = new BbsDTO();
		BbsDAO dao = new BbsDAO();
		ActionForward forward = new ActionForward();

		// String board_num = request.getParameter("board_num");
		String board_name = request.getParameter("board_name");
		String board_pass = request.getParameter("board_pass");
		String board_subject = request.getParameter("board_subject");
		String board_content = request.getParameter("board_content");

		// data.setBoard_num(board_num);
		data.setBoard_name(board_name);
		data.setBoard_pass(board_pass);
		data.setBoard_subject(board_subject);
		data.setBoard_content(board_content);

		boolean result = dao.bbsInsert(data);
		if (result == false) {
			System.out.println("등록 실패");
			return null;
		}
		forward.setRedirect(true);
		forward.setPath("bbsList.do");
		return forward;
	}

}
