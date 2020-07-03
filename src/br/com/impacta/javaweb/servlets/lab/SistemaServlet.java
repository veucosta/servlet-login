package br.com.impacta.javaweb.servlets.lab;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SistemaServlet
 */
@WebServlet("/sistema")
public class SistemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("<html><body><h1>Bem vindo " + request.getParameter("login") + "!</h1>")
							.append("<br>Esta é a página principal do sistema.")
							.append("<br><br><a href=\"/servlet-login/login.html\">Logout</a>")
							.append("</body></html>");
	}

}
