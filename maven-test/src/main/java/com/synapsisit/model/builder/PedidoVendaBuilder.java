package com.synapsisit.model.builder;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.synapsisit.model.Cliente;
import com.synapsisit.model.ItemPedido;
import com.synapsisit.model.PedidoVenda;

public class PedidoVendaBuilder {
	
	
	private PedidoVenda instancia;
	
	public PedidoVendaBuilder() {
		this.instancia = new PedidoVenda();
	}
	
	public PedidoVendaBuilder comClienteVip(String nome){
		definirCliente(nome, true);		
		return this;
	}
	
	public PedidoVendaBuilder semClienteVip(String nome){
		definirCliente(nome, false);		
		return this;
	}

	private void definirCliente(String nome, boolean vip) {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setVip(vip);
		
		this.instancia.setCliente(cliente);		
	}
	
	public PedidoVendaBuilder comItem(String nome, Integer quantidade, String valorUnitario ) {	
		
		ItemPedido item = new ItemPedido();		
		item.setNome(nome);
		item.setQuantidade(quantidade);
		item.setValorUnitario(new BigDecimal(valorUnitario));
		
		if (this.instancia.getItensPedido() == null) {
			this.instancia.setItensPedido(new ArrayList<ItemPedido>());
		}
		
		this.instancia.getItensPedido().add(item);
		
		return this;
	}
	
	public PedidoVenda construir() {
		return this.instancia;
	}	
	
}
