package br.com.impacta.javaweb.servlets.lab;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.impacta.javaweb.servlets.lab.bean.Usuario;

/**
 * Servlet implementation class SistemaServlet
 */
@WebServlet("/sistema")
public class SistemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Usuario usuario = (Usuario) request.getAttribute("usuario");
				
		response.getWriter().append("<html><body><h1>Bem vindo " + usuario.getLogin() + "!</h1>")
							.append("<br>Esta é a página principal do sistema.")
							.append("<br><br><a href=\"/servlet-login/login.html\">Logout</a>")
							.append("</body></html>");
	}

}
