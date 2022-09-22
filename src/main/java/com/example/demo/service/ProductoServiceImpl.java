package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Producto;
import com.example.demo.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.insertar(producto);
	}

	@Override
	public Producto buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscar(id);
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.actualizar(producto);
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iProductoRepository.eliminar(id);
	}

	@Override
	public Producto buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarPorCodigo(codigo);
	}

	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarTodos();
	}

	@Override
	public String eliminarSinRegistro(Integer id) {
		// TODO Auto-generated method stub
		Producto producto = this.buscar(id);
		
		if(producto.getStock()==0) {
			this.iProductoRepository.eliminar(producto.getId());
			return "se ha eliminado el producto";
				
		}else {
			return "no se puede eliminar el producto";
		}
		
	
	}
}
