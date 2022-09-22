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

import com.example.demo.modelo.Bodega;
import com.example.demo.modelo.Producto;
import com.example.demo.service.IBodegaService;

@Controller
@RequestMapping("/bodegas/")
public class BodegaController {
	
	@Autowired
	private IBodegaService iBodegaService;
	
	//lista de productos
	@GetMapping("listaBodegas")
	public String listaBodegas(Bodega bodega, Model modelo) {
		List<Bodega> lista = this.iBodegaService.buscarTodos();
		modelo.addAttribute("bodegas",lista);
		return "vistalistaBodegas";
	}
	
	//insertar
	@PostMapping("insertar")
	public String insertar(Bodega bodega) {
		this.iBodegaService.insertar(bodega);;
		return "redirect:/bodegas/insertarNuevaBodega";
	}
	
	@GetMapping("insertarNuevaBodega")//g
	public String insertarNuevaBodega(Bodega bodega) {
		return "vistainsertarNuevaBodega";
	}

	
	
}
