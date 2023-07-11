package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.entity.ItemPedido;
import com.example.app.model.entity.Pedido;
import com.example.app.model.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido buscarPorId(Long id) {
		Pedido pedido = pedidoRepository.findById(id).get();
		return pedido;
	}

	public double getTotalPedido(Long id) {
		Pedido pedido = pedidoRepository.findById(id).get();
		List<ItemPedido> itens = pedido.getItens();
		double soma = 0;
		for(ItemPedido item : itens) {
			soma = soma + (item.getPreco()*item.getQuantidade());
			System.out.println(soma);
		}
		return soma;
	}
	
	public int getTotalPedidoCliente(Long id) {
		Pedido pedido = pedidoRepository.findById(id).get();
		List<ItemPedido> itens = pedido.getItens();
		int soma = 0;
		for(ItemPedido item : itens) {
			soma++;
		}
		return soma;
	}

	public String getListaPedido(Long id) {
		Pedido pedido = pedidoRepository.findById(id).get();
		List<ItemPedido> itens = pedido.getItens();
		String lista = "";
		for(ItemPedido item : itens) {
			lista = lista + "Produto: "+item.getProduto()+" Quantidade: "+item.getQuantidade()+" Preço "+item.getPreco()+"\n";
		}
		return lista;
	}

	
}
