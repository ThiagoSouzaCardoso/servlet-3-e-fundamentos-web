package br.com.alura.gerenciador.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Tarefa{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("usuario.logado");
		return "/WEB-INF/paginas/logout.html";
	}
	
}
