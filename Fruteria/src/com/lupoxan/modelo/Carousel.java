package com.lupoxan.modelo;

public class Carousel {
	private int id;
	private String texto;
	private String imagen;

	public Carousel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carousel(String texto, String imagen) {
		super();
		this.texto = texto;
		this.imagen = imagen;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Texto: " + texto + "\tImagen: " + imagen;
	}

}
