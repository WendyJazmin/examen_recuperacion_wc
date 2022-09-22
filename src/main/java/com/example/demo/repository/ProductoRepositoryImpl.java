package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Inventario;
import com.example.demo.modelo.Producto;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public Producto buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public Producto buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigoBarrasMaestro =: codigo",Producto.class);
		myQuery.setParameter("codigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p",Producto.class);
		return myQuery.getResultList();
	}
}
