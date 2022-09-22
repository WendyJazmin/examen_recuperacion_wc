package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Bodega;
import com.example.demo.modelo.Inventario;
import com.example.demo.modelo.Producto;
import com.example.demo.service.IGestorInventarioService;
import com.example.demo.service.IInventarioService;

@Controller
@RequestMapping("/inventarios/")
public class InventarioController {
	
	@Autowired
	private IInventarioService iInventarioService;
	
	@Autowired
	private IGestorInventarioService iGestorInventarioService;
	
	//lista de productos
	@GetMapping("listaInventarios")
	public String listaInventarios(Inventario inventario, Model modelo) {
		List<Inventario> lista = this.iInventarioService.buscarTodos();
		modelo.addAttribute("inventarios",lista);
		return "vistaListaInventarios";
	}
	
	/*//insertar
	@PostMapping("insertar")
	public String insertar(Bodega bodega, Producto producto) {
		this.iGestorInventarioService.ingresarInventario(bodega.getNumero(), producto.getCodigoBarrasMaestro(), producto.getStock());
		return "redirect:/inventarios/listaInventarios";
	}
	*/
	@GetMapping("insertarNuevoInventario")//g
	public String insertarNuevoInventario(Bodega bodega, Producto producto) {
		return "vistainsertarNuevoInventario";
	}

	
	
}
