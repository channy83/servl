package reply.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.Action;
import board.action.ActionForward;

public class ReplyController extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		String requestURI = request.getRequestURI();
		String command = null;
		StringTokenizer st = new StringTokenizer(requestURI, "/");
		
		while(st.hasMoreTokens()){
			command = (st.nextToken());
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(requestURI + ", ");
		out.println(command);
		
		
		ActionForward forward = null;
		Action action = null;
		request.setCharacterEncoding("euc-kr");
		
		if(command.equals("replyWrite.ro")){
			action = new ReplyWriteAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
	}
}
}
