package com.lupoxan.modelo;

public class Usuario {
	private String usuario;
	private String password;
	private String email;
	private String nombre;
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", password=" + password + ", email=" + email + ", nombre=" + nombre
				+ "]";
	}


	
	
}
