package br.com.alura.gerenciador.util;

import javax.servlet.http.Cookie;

public class Cookies {

	private Cookie[] cookies;

	public Cookies(Cookie [] cookies) {
		this.cookies = cookies;
	}
	
	
	public Cookie getUsuarioLogado(){
		if(cookies == null){
			return null;
		}
		for (Cookie cookie : cookies) {
			if("usuario.logado".equals(cookie.getName())){
				return cookie;
			}
		}
		
		return null;
	}
	
}
