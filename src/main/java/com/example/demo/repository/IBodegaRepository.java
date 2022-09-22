package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Bodega;

public interface IBodegaRepository {
 
	public void insertar(Bodega bodega);
	public Bodega buscar(Integer id);
	
	public void actualizar(Bodega bodega);
	
	public void eliminar(Integer id);
	
	public Bodega buscarPorNumero(String numero);
	
	public List<Bodega> buscarTodos();
}
