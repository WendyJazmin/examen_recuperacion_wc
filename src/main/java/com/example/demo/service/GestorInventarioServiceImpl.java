package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Bodega;
import com.example.demo.modelo.Inventario;
import com.example.demo.modelo.Producto;

@Service
public class GestorInventarioServiceImpl implements IGestorInventarioService{
	
	@Autowired
	private IInventarioService IInventarioService;

	@Autowired
	private IProductoService IProductoService;
	
	@Autowired
	private IBodegaService IBodegaService;
	
	
	@Override
	public void ingresarProducto(String numeroBodega, String codigo, Integer cantidad) {
		// TODO Auto-generated method stub
		Bodega bodega = this.IBodegaService.buscarPorNumero(numeroBodega);
		Producto producto = this.IProductoService.buscarPorCodigo(codigo);
		producto.getStock();
		for (int i = 1; i <= cantidad; i++) {

			Inventario Inventario = new Inventario();
			Inventario.setBodega(bodega);
			Inventario.setCodigoBarrasIndividual(codigo + "" + i);
			//Inventario.setProductoR(producto);
			//this.registroService.insertar(regi);
		}

		producto.setStock(cantidad);
		this.IProductoService.actualizar(producto);
	}


	@Override
	public void ingresarProductoInventario(String numeroBodega, String codigoBarrasMaestro,
			String codigoBarrasIndividual, Producto producto) {
		// TODO Auto-generated method stub
		Bodega bodega = this.IBodegaService.buscarPorNumero(numeroBodega);
		Inventario inventario = new Inventario();
		this.IProductoService.actualizar(producto);
		List<Producto> listaProductos = new ArrayList<>(); 
		listaProductos.add(producto);
		inventario.setBodega(bodega);
		inventario.setCodigoBarrasIndividual(codigoBarrasIndividual);
		inventario.setProducto(producto);
		//inventario.setProductos(listaProductos);
		listaProductos.forEach(System.out::println);
		//producto.setInventario(inventario);
		
		this.IInventarioService.insertar(inventario);
		
	}

	
}