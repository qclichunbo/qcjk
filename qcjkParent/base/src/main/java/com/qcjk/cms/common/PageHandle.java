package com.qcjk.cms.common;

/**
 * @author liuzeke
 * @version 1.0
 */
public abstract class PageHandle {

	private final static ThreadLocal<Page> PAGE_LOCAL = new ThreadLocal<Page>();

	private PageHandle() {
	}

	public static Page getPage() {
		Page page;
		return (page = PAGE_LOCAL.get()) == null ? new Page() : page;
	}

	public static void setPage(Page page) {
		PAGE_LOCAL.set(page);
	}

	public static Page getPageAndRem() {
		try {
			return PAGE_LOCAL.get();
		} finally {
			PAGE_LOCAL.remove();
		}
	}
}
