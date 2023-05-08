package com.musicrockstar.musicrockstar.jpa;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;
	private String tipo;
	private String fotos;
	private int entrega;
	private float precio;
	private int inventario;
	private int rebaja;

	@OneToMany(mappedBy = "producto")
	private List<Opinion> opiniones;
	//bi-directional many-to-one association to Detalle

	public Producto() {
	}

	public Producto(int id, String nombre, String tipo, String fotos, int entrega, float precio, int inventario, int rebaja) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.fotos = fotos;
		this.entrega = entrega;
		this.precio = precio;
		this.inventario = inventario;
		this.rebaja = rebaja;
	}

	public Producto(int id, String nombre, String tipo, String fotos, int entrega, float precio, int inventario, int rebaja, List<Opinion> opiniones) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.fotos = fotos;
		this.entrega = entrega;
		this.precio = precio;
		this.inventario = inventario;
		this.rebaja = rebaja;
		this.opiniones = opiniones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFotos() {
		return fotos;
	}

	public void setFotos(String fotos) {
		this.fotos = fotos;
	}

	public int getEntrega() {
		return entrega;
	}

	public void setEntrega(int entrega) {
		this.entrega = entrega;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getInventario() {
		return inventario;
	}

	public void setInventario(int inventario) {
		this.inventario = inventario;
	}

	public int getRebaja() {
		return rebaja;
	}

	public void setRebaja(int rebaja) {
		this.rebaja = rebaja;
	}

	public List<Opinion> getOpiniones() {
		return opiniones;
	}

	public void setOpiniones(List<Opinion> opiniones) {
		this.opiniones = opiniones;
	}

	public Opinion addOpinion(Opinion opinion) {
		getOpiniones().add(opinion);
		opinion.setProducto(this);

		return opinion;
	}

}