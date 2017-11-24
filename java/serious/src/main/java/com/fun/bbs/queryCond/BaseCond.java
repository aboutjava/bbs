package com.fun.bbs.queryCond;

public class BaseCond {
	/** 每页条数 */
	private int pageSize = 20;
	/** 所在页面 */
	private int pageIndex = 0;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
