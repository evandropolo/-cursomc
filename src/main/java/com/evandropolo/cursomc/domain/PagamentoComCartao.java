package com.evandropolo.cursomc.domain;

import javax.persistence.Entity;

import com.evandropolo.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDaParcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido,
			Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDaParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDaParcelas() {
		return numeroDaParcelas;
	}

	public void setNumeroDaParcelas(Integer numeroDaParcelas) {
		this.numeroDaParcelas = numeroDaParcelas;
	}
	
	
	
}
