package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Producto;

public interface IProductoService {
 
	public void insertar(Producto producto);
	public Producto buscar(Integer id);
	
	public void actualizar(Producto producto);
	
	public void eliminar(Integer id);
	
	public Producto buscarPorCodigo(String codigo);
	
	public List<Producto> buscarTodos();
	
	public String eliminarSinRegistro(Integer id);
}
