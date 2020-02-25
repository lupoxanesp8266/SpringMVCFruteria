package com.lupoxan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.lupoxan.modelo.Carousel;
import com.lupoxan.modelo.Fruteria;
import com.lupoxan.modelo.Usuario;

public class FruteriaDao {
	JdbcTemplate template;

	public FruteriaDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FruteriaDao(JdbcTemplate template) {
		super();
		this.template = template;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Fruteria> mostrarFrutas() {
		return template.query("select * from vegetales", new RowMapper<Fruteria>() {
			@Override
			public Fruteria mapRow(ResultSet rs, int row) throws SQLException {
				Fruteria p = new Fruteria();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setCategoria(rs.getString(3));
				p.setImagen(rs.getString(4));
				p.setProcedencia(rs.getString(5));
				p.setPrecio(rs.getFloat(6));
				return p;
			}

		});
	}

	public List<Carousel> getSlides() {
		return template.query("select * from carousel", new RowMapper<Carousel>() {
			@Override
			public Carousel mapRow(ResultSet rs, int row) throws SQLException {
				Carousel p = new Carousel();
				p.setTexto(rs.getString(2));
				p.setImagen(rs.getString(3));
				return p;
			}

		});
	}

	public List<Fruteria> porCategorias(String categoria) {
		return template.query("select * from vegetales where categoria = '" + categoria + "'",
				new RowMapper<Fruteria>() {
					@Override
					public Fruteria mapRow(ResultSet rs, int row) throws SQLException {
						Fruteria p = new Fruteria();
						p.setId(rs.getInt(1));
						p.setNombre(rs.getString(2));
						p.setCategoria(rs.getString(3));
						p.setImagen(rs.getString(4));
						p.setProcedencia(rs.getString(5));
						p.setPrecio(rs.getFloat(6));
						return p;
					}

				});
	}

	public int guardar(Fruteria emp) {
		return template.update("insert into vegetales values(null,?,?,?,?,?)", emp.getNombre(), emp.getCategoria(),
				emp.getImagen(), emp.getProcedencia(), emp.getPrecio());
	}

	public int eliminar(int id) {
		return template.update("delete from vegetales where id = " + id);
	}

	public Fruteria buscarFruta(int id) {
		return template.queryForObject("select * from vegetales where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Fruteria>(Fruteria.class));
	}

	public int actualizar(Fruteria emp) {
		return template.update(
				"update vegetales set nombre = ?,categoria = ?,imagen = ?, procedencia = ?, precio = ? where id = ?",
				emp.getNombre(), emp.getCategoria(), emp.getImagen(), emp.getProcedencia(), emp.getPrecio(),
				emp.getId());
	}

	public Usuario loginUsuario(String usuario, String password) {
		List<Usuario> user = new ArrayList<Usuario>();
		user = template.query("select * from user where usuario = '" + usuario + "' and clave = '" + password + "'",
				new RowMapper<Usuario>() {
					@Override
					public Usuario mapRow(ResultSet rs, int row) throws SQLException {
						Usuario u = new Usuario();
						u.setUsuario(rs.getString(1));
						u.setPassword(rs.getString(2));
						u.setEmail(rs.getString(3));
						u.setNombre(rs.getString(4));
						return u;
					}

				});
		if (!user.isEmpty()) {
			return user.get(0);
		} else {
			return null;
		}

	}

	public int altaUsuario(Usuario user) {
		return template.update("insert into user values(?,?,?,?)", user.getUsuario(), user.getPassword(),
				user.getEmail(), user.getNombre());

	}

}
