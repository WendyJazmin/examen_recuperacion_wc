package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Bodega;
import com.example.demo.repository.IBodegaRepository;

@Service
public class BodegaServiceImpl implements IBodegaService{

	@Autowired
	private IBodegaRepository iBodegaRepository;

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void insertar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.iBodegaRepository.insertar(bodega);
	}

	@Override
	public Bodega buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iBodegaRepository.buscar(id);
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void actualizar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.iBodegaRepository.actualizar(bodega);
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iBodegaRepository.eliminar(id);
	}

	@Override
	public Bodega buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iBodegaRepository.buscarPorNumero(numero);
	}

	@Override
	public List<Bodega> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iBodegaRepository.buscarTodos();
	}
}
