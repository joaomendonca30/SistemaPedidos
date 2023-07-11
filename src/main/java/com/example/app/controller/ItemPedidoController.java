package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.entity.ItemPedido;
import com.example.app.model.repository.ItemPedidoRepository;

@RestController
@RequestMapping("/api/itempedido")
public class ItemPedidoController {

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@GetMapping
	public List<ItemPedido> listAll(){
		List<ItemPedido> itensPedido = itemPedidoRepository.findAll();
		return itensPedido;
	}
	
	@GetMapping("/{id}")
	public ItemPedido getById(@PathVariable Long id) {
		ItemPedido itemPedido = itemPedidoRepository.findById(id).get();
		return itemPedido;
	}
	
	@PostMapping
	public ItemPedido insert(@RequestBody ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}
	
}
