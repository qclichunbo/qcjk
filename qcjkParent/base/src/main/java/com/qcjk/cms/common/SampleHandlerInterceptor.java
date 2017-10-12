package com.qcjk.cms.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.qcjk.cms.util.BlankUtil;

public class SampleHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 过滤乱码
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		// 解决跨域
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type");
		
		return true;
	}

	private void getPage(HttpServletRequest request) {
		String pageSize = request.getParameter("pageSize");
		String pageNum = request.getParameter("pageNum");
		String isDesc = request.getParameter("isDesc");
		if (BlankUtil.httpNotNull(pageNum) || BlankUtil.httpNotNull(pageSize))
			return;
		PageHandle.setPage(new Page(Integer.valueOf(pageSize), Integer
				.valueOf(pageNum), true, "1".equals(isDesc) ? false : true));

	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
