package com.projeto.avalicao.apideavaicao.erroTratamento;

public class ErroDeBadRequest extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ErroDeBadRequest(String msg) {
		super(msg);
	}
	
}
