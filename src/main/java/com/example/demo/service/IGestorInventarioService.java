package com.example.demo.service;

import com.example.demo.modelo.Producto;

public interface IGestorInventarioService {

	public void ingresarProducto(String numeroBodega, String codigo, Integer cantidad);
	
	void ingresarProductoInventario(String numeroBodega, String codigoBarrasMaestro, String codigoBarrasIndividual, Producto producto);
}
