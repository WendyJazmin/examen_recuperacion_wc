package com.example.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="inventario")
public class Inventario {

	@Id
	@Column(name ="inve_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inve_id_seq")
	@SequenceGenerator(name="inve_id_seq", sequenceName = "inve_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name ="inve_codigo_barras_individual")
	private String codigoBarrasIndividual;
	
	@ManyToOne
	@JoinColumn(name="inve_bode_id")
	private Bodega bodega;
	
	@ManyToOne
	@JoinColumn(name="inve_prod_id")
	private Producto producto;

	
	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarrasIndividual() {
		return codigoBarrasIndividual;
	}

	public void setCodigoBarrasIndividual(String codigoBarrasIndividual) {
		this.codigoBarrasIndividual = codigoBarrasIndividual;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	
}
