package com.lupoxan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lupoxan.dao.FruteriaDao;
import com.lupoxan.modelo.Carousel;
import com.lupoxan.modelo.Fruteria;
import com.lupoxan.modelo.Usuario;

@RequestMapping("/backendcontroller")
@Controller
public class BackEndController {
	@Autowired
	FruteriaDao dao;
	public static Usuario user = null;

	// Index back end fruteria
	@RequestMapping(value = "/home")
	public ModelAndView listadoTodo() {
		ModelAndView modelo = null;
		if (user != null) {
			List<Fruteria> frutas = dao.mostrarFrutas();
			modelo = new ModelAndView("backendHome");
			modelo.addObject("frutas", frutas);
			
		}else {
			modelo = new ModelAndView("loginBack");
			modelo.addObject("command", new Usuario());
			
		}
		return modelo;
		
	}
	
	@RequestMapping(value = "/logueado", method = RequestMethod.POST)
	public ModelAndView inicioUsuario(@ModelAttribute("fruta") Usuario user) {
		ModelAndView modelo = new ModelAndView();

		user = dao.loginUsuario(user.getUsuario(), user.getPassword());
		if (user != null) {
			if (!user.getUsuario().equals("admin")) {
				List<Fruteria> frutas = dao.mostrarFrutas();
				List<Carousel> slides = dao.getSlides();
				modelo = new ModelAndView("frontendHome");
				modelo.addObject("frutas", frutas);
				modelo.addObject("slides", slides);
				modelo.addObject("user", user);
			} else {
				BackEndController.user = user;
				modelo = new ModelAndView("redirect:../backendcontroller/home");
			}
		}
		return modelo;
	}

	@RequestMapping(value = "/back")
	public ModelAndView volver() {
		user = null;
		ModelAndView modelo = new ModelAndView("redirect:../frontendcontroller/login");
		modelo.addObject("command", new Usuario());
		return modelo;
	}

	// Formulario Nuevo vegetal
	@RequestMapping(value = "/aniadirFruta", method = RequestMethod.GET)
	public String aniadirFruta(Model modelo) {
		modelo.addAttribute("command", new Fruteria());
		return "aniadirFruta";
	}

	// Boton del formulario de Nuevo vegetal
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String save(@ModelAttribute("fruta") Fruteria producto) {
		dao.guardar(producto);
		return "redirect:/backendcontroller/home";
	}

	// Botón eliminar el vegetal
	@RequestMapping(value = "/eliminarVegetal/{id}", method = RequestMethod.GET)
	public ModelAndView eliminarVegetal(@PathVariable int id) {
		dao.eliminar(id);
		return new ModelAndView("redirect:/backendcontroller/home");
	}

	// Formulario editar vegetal
	@RequestMapping(value = "/editarVegetal/{id}", method = RequestMethod.GET)
	public String editarFruta(@PathVariable int id, Model modelo) {
		modelo.addAttribute("command", dao.buscarFruta(id));
		return "editarFruta";
	}

	// Botón del formulario editar vegetal
	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public String edit(@ModelAttribute("emp") Fruteria fruta) {
		dao.actualizar(fruta);
		return "redirect:/backendcontroller/home";
	}

}
