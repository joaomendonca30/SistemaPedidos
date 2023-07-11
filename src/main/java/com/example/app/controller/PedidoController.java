package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.entity.Pedido;
import com.example.app.model.repository.PedidoRepository;
import com.example.app.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public List<Pedido> listAll(){
		List<Pedido> pedidos = pedidoRepository.findAll();
		return pedidos;
	}
	
	@GetMapping("/totalPedido/{id}")
	public double getTotalPedido(@PathVariable Long id) {
		return pedidoService.getTotalPedido(id);
	}

	@GetMapping("/totalPedidoCliente/{id}")
	public int getTotalPedidoCliente(@PathVariable Long id) {
		return pedidoService.getTotalPedidoCliente(id);
	}
	
	@GetMapping("/listaPedido/{id}")
	public String getListaCliente(@PathVariable Long id) {
		return pedidoService.getListaPedido(id);
	}
	
	@GetMapping("/{id}")
	public Pedido getById(@PathVariable Long id) {
		Pedido pedido = pedidoRepository.findById(id).get();
		return pedido;
	}
	
	@PostMapping
	public Pedido insert(@RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

}
