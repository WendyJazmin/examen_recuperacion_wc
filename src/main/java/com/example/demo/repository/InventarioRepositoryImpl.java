package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Inventario;

@Repository
@Transactional
public class InventarioRepositoryImpl implements IInventarioRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void insertar(Inventario inventario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(inventario);
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public Inventario buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Inventario.class, id);
	}

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void actualizar(Inventario inventario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(inventario);
	}

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public List<Inventario> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Inventario> myQUery = this.entityManager.createQuery("SELECT i FROM Inventario i",Inventario.class);
		return myQUery.getResultList();
	}
}
