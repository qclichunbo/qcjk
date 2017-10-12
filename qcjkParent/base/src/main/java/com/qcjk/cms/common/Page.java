package com.qcjk.cms.common;

public class Page {

	/**
	 * 1 0-9 2 10-19 3 20-29
	 * 
	 * 1 0-9 (pageNum-1)*pageSize - pageNum*pageSize-1
	 * 
	 * 
	 */

	// 椤靛ぇ灏�
	private int pageSize;
	// 褰撳墠椤�
	private int pageNum;
	// 鎬婚〉鏁�
	private int pageCount;

	private int count;
	// 鏄惁鍒嗛〉
	private boolean isPage;
	// 鏄惁椤哄簭
	private boolean isDesc;
	// 璧峰
	private int start;
	// 缁撴潫
	private int end;

	public Page() {
	}

	public Page(int pageSize, int pageNum) {
		this(pageSize, pageNum, false, false);
	}

	public Page(int pageSize, int pageNum, boolean isPage) {
		this(pageSize, pageNum, isPage, false);
	}

	public Page(int pageSize, int pageNum, boolean isPage, boolean isDesc) {
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.isPage = isPage;
		this.isDesc = isDesc;
		this.start = (pageNum - 1) * pageSize;
		this.end = pageNum * pageSize - 1;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isPage() {
		return isPage;
	}

	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}

	public boolean isDesc() {
		return isDesc;
	}

	public void setDesc(boolean isDesc) {
		this.isDesc = isDesc;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
