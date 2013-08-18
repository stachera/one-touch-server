package com.up.onetouch.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.up.onetouch.constants.Mensagens;

@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class Response {

	private Mensagens mensagem;

	public Mensagens getMensagem() {
		return mensagem;
	}
	public void setMensagem(Mensagens mensagens) {
		this.mensagem = mensagens;
	}
}