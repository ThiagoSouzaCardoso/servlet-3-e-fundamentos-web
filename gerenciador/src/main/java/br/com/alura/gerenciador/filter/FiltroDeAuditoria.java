package br.com.alura.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.Usuario;


@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chains) throws IOException, ServletException {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
		String uri = httpRequest.getRequestURI();
		String usuario = "Deslogado";
		
			Usuario usuarioLogado = (Usuario)httpRequest.getSession().getAttribute("usuario.logado");
		
				if(usuarioLogado != null){
					usuario = usuarioLogado.getEmail();
				}
			
			 System.out.println("Usuario "+ usuario +" acessando a URI " + uri);
	
			 chains.doFilter(request, response);
	}
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
