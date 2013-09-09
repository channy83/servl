package reply.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.model.ReplyDAO;
import reply.model.ReplyDTO;
import board.action.Action;
import board.action.ActionForward;

public class ReplyWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ReplyDTO data = new ReplyDTO();
		ReplyDAO dao = new ReplyDAO();
		ActionForward forward = new ActionForward();

//		int reply_board_num = Integer.parseInt(request.getParameter("reply_board_num"));
		String reply_board_num = request.getParameter("reply_board_num");
		String reply_name = request.getParameter("reply_name");
		String reply_content = request.getParameter("reply_content");
//		String reply_date = request.getParameter("reply_date");
		
		System.out.println(reply_board_num+", "+reply_name+", "+reply_content);
		data.setReply_board_num(reply_board_num);
		data.setReply_name(reply_name);
		data.setReply_content(reply_content);
//		data.setReply_date(reply_date);

		dao.replyInsert(data);

		forward.setRedirect(true);
		forward.setPath(".bbsList.do");
		return forward;

	}
}
