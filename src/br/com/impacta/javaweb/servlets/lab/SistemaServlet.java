package br.com.impacta.javaweb.servlets.lab;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		//Usuario usuario = (Usuario) request.getAttribute("usuario"); scopos
		
		Cookie[] cookies = request.getCookies();
		String cookEmail = null;
		
		//busca de um cookie gravado de nome email
		if(cookies != null) {
		for(Cookie cookie : cookies) {
			if (cookie.getName().equals("email")) {
				cookEmail = cookie.getValue();
				break;
			}
		}
	}
		
		//caso o valor seja nulo, direciona a requisição para a servlet com url/coletaemail
		
		if(cookEmail == null || cookEmail.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/coletaemail");
			rd.forward(request,  response);
		}
		
		response.getWriter().append("<html><body><h1>Bem vindo " + usuario.getLogin() + "!</h1>")
							.append("<br>Seu email é : " + cookEmail)
							.append("<br>Esta é a página principal do sistema.")
							.append("<br><br><a href=\"/servlet-login/login.html\">Logout</a>")
							.append("</body></html>");
	}

}
