package board.action;

import board.model.BbsDAO;

public class PagingAction {

	public int startPage; // 현재 페이지 리스트 첫 페이지
	public int endPage; // 현재 페이지 리스트 마지막 페이지
	public int lastPage; // 총 게시물 갯수로 나올 수 있는 최대 페이지
	public int maxList; // 한 화면에 보여줄 게시물 수. BbsDAO에서 설정
	public int dividePage; // 한 화면에 보여줄 페이지 수. BbsDAO에서 설정

	public PagingAction(int currentPage, int maxList, int dividePage) {

		this.maxList = maxList;
		this.dividePage = dividePage;

		startPage = (int) Math.ceil((double) currentPage / dividePage)
				* dividePage - (dividePage - 1);
		endPage = calEndPage();
		lastPage = calLastPage();

	}

	public int calLastPage() {

		BbsDAO dao = new BbsDAO();
		int listCount = dao.getListCount();
		
		lastPage = (int)Math.ceil((double)listCount / maxList);
		/*
		lastPage = (listCount / maxList);
		if ((listCount % maxList) != 0) {
			lastPage += 1;
		}
*/
		if (endPage > lastPage) {
			endPage = lastPage;
		}
		return lastPage;
	}

	public int calEndPage() {

		/*System.out.println("startPage = " + startPage);
		System.out.println("maxList = " + maxList);*/
		endPage = (startPage + dividePage) - 1;
		return endPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getMaxList() {
		return maxList;
	}

	public void setMaxList(int maxList) {
		this.maxList = maxList;
	}

}
