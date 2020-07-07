package br.com.impacta.javaweb.servlets.lab;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdicionaEmailCookieServlet
 */
@WebServlet("/adicionaEmailCookie")
public class AdicionaEmailCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperar o parametro email enviado no formulario e adicionar o valor como cookie no browser do usuário
		String emailInformado = request.getParameter("email");
		Cookie cookieEmail = new Cookie("email", emailInformado);
		response.addCookie(cookieEmail);
		
		response.sendRedirect("http://localhost:8080/servlet-login/login.html");
	}

}
