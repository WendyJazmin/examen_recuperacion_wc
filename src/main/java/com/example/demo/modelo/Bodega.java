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
@Table(name="bodega")
public class Bodega {

	@Id
	@Column(name ="bode_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bode_id_seq")
	@SequenceGenerator(name="bode_id_seq", sequenceName = "bode_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name ="bode_nombre")
	private String nombre;
	
	@Column(name ="bode_numero")
	private String numero;
	
	@Column(name ="bode_direccion")
	private String direccion;
	
	@Column(name ="bode_telefono")
	private String telefono;
	
	@OneToMany(mappedBy="bodega")
	private List<Inventario> inventariosB;

	
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Inventario> getInventariosB() {
		return inventariosB;
	}

	public void setInventariosB(List<Inventario> inventariosB) {
		this.inventariosB = inventariosB;
	}
	
	
}
