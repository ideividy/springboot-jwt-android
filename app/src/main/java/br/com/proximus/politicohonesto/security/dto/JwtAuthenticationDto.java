package br.com.proximus.politicohonesto.security.dto;

public class JwtAuthenticationDto {
	
	private String email;
	private String senha;

	public JwtAuthenticationDto() {
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "JwtAuthenticationRequestDto [email=" + email + ", senha=" + senha + "]";
	}

}