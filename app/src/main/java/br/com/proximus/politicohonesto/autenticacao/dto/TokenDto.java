package br.com.proximus.politicohonesto.autenticacao.dto;

public class TokenDto {

	private String token; 
	
	public TokenDto() {
	}
	
	public TokenDto(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}