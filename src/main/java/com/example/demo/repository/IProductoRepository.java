package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Producto;

public interface IProductoRepository {
 
	public void insertar(Producto producto);
	public Producto buscar(Integer id);
	
	public void actualizar(Producto producto);
	
	public void eliminar(Integer id);
	
	public Producto buscarPorCodigo(String codigo);
	
	public List<Producto> buscarTodos();
	
}
