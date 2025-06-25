package com.gn.common.wrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class AnonymousWrapper extends HttpServletRequestWrapper {

	public AnonymousWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if ("writer".equals(name)) {
			if (value == null || !"익명".equals(value))
				value = "익명";
		}

		return value;
	}

}
