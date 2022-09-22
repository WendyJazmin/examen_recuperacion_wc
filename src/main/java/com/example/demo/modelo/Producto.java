package com.example.demo.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {

	@Id
	@Column(name ="prod_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_id_seq")
	@SequenceGenerator(name="prod_id_seq", sequenceName = "_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name ="prod_nombre")
	private String nombre;
	
	@Column(name ="prod_codigo_barras_maestro")
	private String codigoBarrasMaestro;
	
	@Column(name ="prod_categoria")
	private String categoria;
	
	@Column(name ="prod_stock")
	private Integer stock=0;
	
	@OneToMany(mappedBy="producto")
	private List<Inventario> inventariosP;

	
	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoBarrasMaestro() {
		return codigoBarrasMaestro;
	}

	public void setCodigoBarrasMaestro(String codigoBarrasMaestro) {
		this.codigoBarrasMaestro = codigoBarrasMaestro;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<Inventario> getInventariosP() {
		return inventariosP;
	}

	public void setInventariosP(List<Inventario> inventariosP) {
		this.inventariosP = inventariosP;
	}
	
	
	
}
