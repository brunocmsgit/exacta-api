package br.com.exacta.exactaapi.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity
@Table(name = "gasto")
public class Gasto implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Length(min = 1, max = 100)
	@Column(name = "nome_pessoa")
	private String nomePessoa;
	
	@NotNull
	@Length(min = 1, max = 200)
	private String descricao;
	
	@Column(name = "data_hora", columnDefinition = "TIMESTAMP")
	private LocalDateTime dataHora; 
	
	@NotNull
	@DecimalMin(value = "1")
	private BigDecimal valor;
	
	@NotNull
	@Length(min = 1, max = 200)
	private String tags;
	
}
