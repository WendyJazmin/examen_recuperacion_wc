package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Inventario;

public interface IInventarioService {
 
	public void insertar(Inventario inventario);
	public Inventario buscar(Integer id);
	
	public void actualizar(Inventario inventario);
	
	public void eliminar(Integer id);
	
	public List<Inventario> buscarTodos();
	
	public Inventario buscarCodigoBarras(String codigoBarrasIndividual);
}
