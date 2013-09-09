package board.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController extends HttpServlet {

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		// String contextPath = request.getContextPath();
		// String command = requestURI.substring(contextPath.length());

		String command = null;
		StringTokenizer st = new StringTokenizer(requestURI, "/");

		while (st.hasMoreTokens()) {
			command = (st.nextToken());
		}

		// system.out.println(contextPath + ", ");
		// System.out.println("requestURI= "+requestURI);
		// System.out.println("command1= "+command);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(requestURI + ", ");
		out.println(command);

		ActionForward forward = null;
		Action action = null;
		request.setCharacterEncoding("euc-kr");

		if (command.equals("bbsWrite.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/bbs/writeForm.jsp");
		} else if (command.equals("bbsWriteAction.do")) {
			action = new BbsWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("bbsList.do")) {
			// String pageNum = request.getParameter("page");
			// System.out.println(pageNum);
			action = new BbsListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("bbsView.do")) {
			action = new BbsViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("bbsUpdate.do")) {
			action = new BbsUpdateView();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("bbsUpdateAction.do")) {
			action = new BbsUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("bbsDelete.do")) {

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./bbs/delete.jsp");
		} else if (command.equals("bbsDeleteAction.do")) {
			action = new BbsDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(forward
						.getPath());
				rd.forward(request, response);
			}
		}

	}
}
