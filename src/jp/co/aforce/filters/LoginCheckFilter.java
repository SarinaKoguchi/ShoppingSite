package jp.co.aforce.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("ログインチェック");

		try {

			HttpSession session = ((HttpServletRequest) request).getSession();
			String login_state = (String) session.getAttribute("login_state");

			if (login_state != null) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/viewsBeforeLogin/login.jsp");
			}
		} catch (ServletException se) {
		} catch (IOException e) {
		}
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}

}
