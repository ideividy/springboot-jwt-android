package br.com.proximus.politicohonesto.security;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO to get result from server
 * @param <T>
 * @author Deividy Pinheiro
 */
public class Response<T> {

	private T data;
	private List<String> errors;
	
	public Response() {
		
	}

	/**
	 *
	 * @return <T></T>
	 */
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<String> getErrors() {
		if(this.errors == null) {
			this.errors = new ArrayList<>();
		}
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
	
}