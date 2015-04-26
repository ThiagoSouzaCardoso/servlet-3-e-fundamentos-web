package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/executa")
public class Controller extends HttpServlet{

	private static final long serialVersionUID = -5058858478816760722L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		  String nomeTarefa = req.getParameter("tarefa");
		  String nomeDaClasse = "br.com.alura.gerenciador.servlet." + nomeTarefa;
		  if(nomeTarefa == null){
			  throw new ServletException("Tarefa Invalida");
		  }
		try {
			Class<?> type = Class.forName(nomeDaClasse);
			Tarefa tarefa = (Tarefa) type.newInstance();
			String pagina = tarefa.executa(req, resp);
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
		} catch (ClassNotFoundException  | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
	}
	
	
}
