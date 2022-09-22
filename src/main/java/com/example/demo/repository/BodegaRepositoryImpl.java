package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Bodega;
import com.example.demo.modelo.Inventario;

import net.bytebuddy.asm.Advice.This;

@Repository
@Transactional
public class BodegaRepositoryImpl implements IBodegaRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void insertar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.entityManager.persist(bodega);
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public Bodega buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Bodega.class, id);
	}

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void actualizar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.entityManager.merge(bodega);
	}

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public Bodega buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Bodega> myQuery = this.entityManager.createQuery("SELECT b FROM Bodega b WHERE b.numero =: numero",Bodega.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public List<Bodega> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Bodega> myQuery = this.entityManager.createQuery("SELECT b FROM Bodega b",Bodega.class);
		return myQuery.getResultList();
	}
}
