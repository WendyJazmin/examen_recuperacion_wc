package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Bodega;

public interface IBodegaService {
 
	public void insertar(Bodega bodega);
	public Bodega buscar(Integer id);
	
	public void actualizar(Bodega bodega);
	
	public void eliminar(Integer id);
	
	public Bodega buscarPorNumero(String numero);
	
	public List<Bodega> buscarTodos();
}
