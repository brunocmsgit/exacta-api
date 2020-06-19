package br.com.exacta.exactaapi.controlleradvice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErroResponse {

	private String campo;
	private String erro;

}
