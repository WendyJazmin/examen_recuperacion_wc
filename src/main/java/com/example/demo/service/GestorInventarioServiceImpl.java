package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Bodega;
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
	}

	
}