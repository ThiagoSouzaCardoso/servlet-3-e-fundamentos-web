package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = -9146769213033277276L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
	
        String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		PrintWriter writer = resp.getWriter();
		if(usuario == null){
			writer.println("<html><body>Usuario Invalido</body></html>");
		}else{
			req.getSession().setAttribute("usuario.logado", usuario);
			writer.println("<html><body>Usuario: logado com sucesso com o email "+email+"</body></html>");			
		}
		
	
	}

}
