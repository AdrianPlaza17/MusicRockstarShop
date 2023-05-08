package com.musicrockstar.musicrockstar.jpa;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@NamedQuery(name="Opinion.findAll", query="SELECT o FROM Opinion o")
public class Opinion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String texto;
	private int valoracion;

	private String fecha;


	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;

	//bi-directional many-to-one association to Producto

	public Opinion(int id, String texto, int valoracion, Producto producto) {
		this.id = id;
		this.texto = texto;
		this.valoracion = valoracion;
		this.producto = producto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Opinion() {
	}
}