package com.up.onetouch.constants;

public enum Mensagens {
	
	// Info messages
	LOGIN_OK(100, "Login realizado com sucesso"),
	PERSISTE_OK(101, "Dados registrados com sucesso"),
	
	// Warning messages
	WARN_DADOS_INCORRETOS(500, "Informe os dados corretamente"),
	
	// Error messages
	ERRO_LOGIN_INVALIDO(900, "Login e/ou senha inválido"),
	ERRO_REDE(901, "Erro na rede"),
	ERRO_BD(902, "Erro ao salvar dados"),
	ERRO_PREFERENCES(903, "Erro ao salvar preferencias"),
	;
	
	
	public Integer codigo;
	public String mensagem;
	
	private Mensagens(Integer codigo, String mensagem){
		this.codigo = codigo;
		this.mensagem = mensagem;
	}
}
