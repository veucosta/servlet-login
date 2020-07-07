package br.com.impacta.javaweb.servlets.lab;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.impacta.javaweb.servlets.lab.bean.Usuario;

/**
 * Servlet Filter implementation class FiltroDeAutenticacao
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/sistema" })
public class FiltroDeAutenticacao implements Filter {


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");
		
		if(usuario != null) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}else {		
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("http://localhost:8080/servlet-login/login.html");
		}
	}

}
