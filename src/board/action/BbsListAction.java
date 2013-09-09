package board.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BbsDAO;
import board.model.BbsDTO;

public class BbsListAction implements Action{
	/*
	BbsDAO dao = new BbsDAO();
	private List<BbsDTO> list = new ArrayList<BbsDTO>();

	*/
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		BbsDAO dao = new BbsDAO();
//		ArrayList<BbsDTO> list = new ArrayList<BbsDTO>();
		ArrayList<Object> list = new ArrayList<Object>();
		
		String page = request.getParameter("page");
		
		if(page==null){
			page = "1";
		}
		
		int currentPage = Integer.parseInt(page);
		
		list = dao.bbsList(currentPage);
		
//		request.setAttribute("list", list);
		
		PagingAction paging = (PagingAction)list.get(0);
		@SuppressWarnings("unchecked")
		ArrayList<BbsDTO> listBoard = (ArrayList<BbsDTO>)list.get(1);
		
		
		request.setAttribute("listBoard", listBoard);
		request.setAttribute("paging", paging);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/bbs/list.jsp");
		return forward;
	}


	
/*
	public BbsDAO getDao() {
		return dao;
	}


	public void setDao(BbsDAO dao) {
		this.dao = dao;
	}


	public List<BbsDTO> getList() {
		return list;
	}


	public void setList(List<BbsDTO> list) {
		this.list = list;
	}


	public void setList(ArrayList<BbsDTO> list) {
		this.list = list;
	}
*/
}
