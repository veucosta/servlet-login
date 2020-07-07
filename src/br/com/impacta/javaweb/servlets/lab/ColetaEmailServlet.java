package br.com.impacta.javaweb.servlets.lab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.impacta.javaweb.servlets.lab.bean.Usuario;

/**
 * Servlet implementation class ColetaEmailServlet
 */
@WebServlet("/coletaemail")
public class ColetaEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		out.println("<html><head>");
		out.println("<title>Cadastro de Email</title>");
		out.println("<body>");
		out.println("<h2>" + usuario.getLogin() + " informe seu email: </h2></br>");
		out.println("<form method=\"post\" action=\"adicionaEmailCookie\">");
		out.println("Email: </br> <input type=\"text\" name=\"email\" size=\"80\"> </br>");
		out.println("<p=<input type=\"Submit\" value=\"Enviar\"> </p>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
