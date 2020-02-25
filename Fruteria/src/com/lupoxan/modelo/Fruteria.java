package com.lupoxan.modelo;

public class Fruteria {
	private int id;
	private String nombre;
	private String categoria;
	private String imagen;
	private String procedencia;
	private float precio;

	public Fruteria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fruteria(int id, String nombre, String categoria, String imagen, String procedencia, float precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.imagen = imagen;
		this.procedencia = procedencia;
		this.precio = precio;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "ID: " + id + "\tNombre: " + nombre + "\tCategoria: " + categoria + "\tImagen: " + imagen
				+ "\tProcedencia: " + procedencia + "\tPrecio: " + precio;
	}

}
