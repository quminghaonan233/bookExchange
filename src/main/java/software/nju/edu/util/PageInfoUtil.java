package software.nju.edu.util;

import java.io.Serializable;
import java.util.List;

public class PageInfoUtil<T> implements Serializable {
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public int getNavigatePages() {
		return navigatePages;
	}

	public void setNavigatePages(int navigatePages) {
		this.navigatePages = navigatePages;
	}

	public int[] getNavigatepageNums() {
		return navigatepageNums;
	}

	public void setNavigatepageNums(int[] navigateNums) {
		this.navigatepageNums = navigateNums;
	}

	public int getNavigateFirstPage() {
		return navigateFirstPage;
	}

	public void setNavigateFirstPage(int navigateFirstPage) {
		this.navigateFirstPage = navigateFirstPage;
	}

	public int getNavigateLastPage() {
		return navigateLastPage;
	}

	public void setNavigateLastPage(int navigateLastPage) {
		this.navigateLastPage = navigateLastPage;
	}

	private static final long serialVersionUID = 1L;
	// 当前页
	private int pageNum;
	// 每页结果数
	private int pageSize;
	// 当前页结果数
	private int size;
	// 当前页起始行
	private int startRow;
	// 当前页终止行
	private int endRow;
	// 总结果数
	private int total;
	// 总页数
	private int pages;
	// 页面上的子列表（从父列表中截取，适合本页面的列表）
	private List<T> list;
	// 上一页 pageNum
	private int prePage;
	// 下一页 pageNum
	private int nextPage;
	// 是否为首页
	private boolean isFirstPage = false;
	// 是否为末页
	private boolean isLastPage = false;
	// 是否还有前一页
	private boolean hasPreviousPage = false;
	// 是否还有后一页
	private boolean hasNextPage = false;
	// 导航上的页码数量
	private int navigatePages;
	// 导航页码数组
	private int[] navigatepageNums;
	// 导航的第一个页码
	private int navigateFirstPage;
	// 导航的最后一个页码
	private int navigateLastPage;
	
	public PageInfoUtil(List<T> fatherList, int pageNum, int pageSize) {
		this.navigatePages = 8;
		
		this.total = fatherList.size();
		
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pages = computePages(pageSize, total);
		this.size = computeSize(pageNum, pageSize, pages, total);
		this.startRow = computeStartRow(pageNum, pageSize);
		this.endRow = computeEndRow(pageNum, pageSize, size);
		System.out.println("startRow = " + startRow);
		System.out.println("endRow = " + endRow);
		this.list = fatherList.subList(startRow - 1, endRow);
		this.prePage = pageNum - 1;
		this.nextPage = pageNum + 1;
		this.isFirstPage = (pageNum == 1 ? true : false);
		this.isLastPage = (pageNum == pages ? true : false);
		this.hasPreviousPage = (prePage > 0 ? true : false);
		this.hasNextPage = (nextPage > pages ? true : false);
		
		
		computeNavigateNums();
		
		
	}
	
	private int computePages(int pageSize, int total) {
		if (total <= pageSize)
			return 1;
		if (total % pageSize == 0)
			return total / pageSize;
		else
			return total / pageSize + 1;
	}
	
	private int computeSize(int pageNum, int pageSize, int pages, int total) {
		if (pageNum < pages)
			return pageSize;
		else
			return total - (pages - 1) * pageSize;
	}
	
	private int computeStartRow(int pageNum, int pageSize) {
		return (pageNum - 1) * pageSize + 1;
	}
	
	private int computeEndRow(int pageNum, int pageSize, int size) {
		return (pageNum - 1) * pageSize + size;
	}
	
	private void computeNavigateNums() {
		if (pages <= navigatePages) {
			navigatepageNums = new int[pages];
			for (int i = 0; i < pages ; i++)
				navigatepageNums[i] = i + 1;
		} else {
			navigatepageNums = new int[navigatePages];
			int startNum = (pageNum - navigatePages) / 2;
			int endNum = (pageNum + navigatePages) / 2;
			
			if (startNum < 1) {
				startNum = 1;
				for (int i = 0; i < navigatePages; i++)
					navigatepageNums[i] = startNum ++;
				
			} else if (endNum > pages) {
				endNum = pages;
				for (int i = pages - 1; i >= 0; i--)
					navigatepageNums[i] = endNum --;
				
			} else {
				for (int i = 0; i < navigatePages; i++)
					navigatepageNums[i] = startNum ++;
				
			}
		}
	}
	
	public String toString() {
		return "PageInfoUtil{"
				+ "pageNum=" + pageNum + ", "
				+ "pageSize=" + pageSize + ", "
				+ "size=" + size + ", "
				+ "startRow=" + startRow + ", "
				+ "endRow=" + endRow + ", "
				+ "total=" + total + ", "
				+ "pages=" + pages + ", "
				+ "isFirstPage=" + isFirstPage + ", "
				+ "isLastPage=" + isLastPage + ", "
				+ "hasPreviousPage=" + hasPreviousPage + ", "
				+ "hasNextPage=" + hasNextPage + ", "
				+ "}";
	}
	

}
