package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Producto;
import com.example.demo.service.IProductoService;

@Controller
@RequestMapping("/productos/")
public class ProductoController {
	
	@Autowired
	private IProductoService iProductoService;
	
	//lista de productos
	@GetMapping("listaProductos")
	public String listaProductos(Producto producto, Model modelo) {
		List<Producto> lista = this.iProductoService.buscarTodos();
		modelo.addAttribute("productos",lista);
		return "vistalistaProductos";
	}
	
	//insertar
	@PostMapping("insertar")
	public String insertar(Producto producto) {
		this.iProductoService.insertar(producto);
		return "redirect:/productos/listaProductos";
	}
	
	@GetMapping("insertarNuevoProducto")//g
	public String insertarNuevoProducto(Producto producto) {
		return "vistainsertarNuevoProducto";
	}

	//eliminar
	@DeleteMapping("eliminar/{id}")
	public String eliminar(@PathVariable("id")Integer id,Model modelo) {
		String texto = this.iProductoService.eliminarSinRegistro(id);
		modelo.addAttribute("texto",texto);
		return "vistaEliminar";
	}
	
}
