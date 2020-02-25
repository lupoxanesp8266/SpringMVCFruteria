package com.lupoxan.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
import com.lupoxan.modelo.CreatePDF;
import com.lupoxan.modelo.Fruteria;
import com.lupoxan.modelo.Usuario;

@RequestMapping("/frontendcontroller")
@Controller
public class FrontEndController {
	@Autowired
	JavaMailSender emailSender;
	@Autowired
	FruteriaDao dao;
	List<Fruteria> carro = new ArrayList<Fruteria>();
	float precioTotal = 0;
	static Usuario user = null;

	@RequestMapping(value = "/registrarse", method = RequestMethod.POST)
	public String registroCompleto(@ModelAttribute("user") Usuario user) {
		dao.altaUsuario(user);
		FrontEndController.user = user;
		return "redirect:home";
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
				FrontEndController.user = user;
			} else {
				BackEndController.user = user;
				modelo = new ModelAndView("redirect:../backendcontroller/home");
			}
		}
		return modelo;
	}

	@RequestMapping(value = "/login")
	public String login(Model modelo) {
		modelo.addAttribute("command", new Usuario());
		return "loginBack";
	}

	@RequestMapping(value = "/registro")
	public String register(Model modelo) {
		modelo.addAttribute("command", new Usuario());
		return "registro";
	}

	@RequestMapping(value = "/home")
	public ModelAndView listadoTodo() {

		ModelAndView modelo = new ModelAndView("frontendHome");

		if (user == null) {
			user = new Usuario();
			user.setNombre("Anónimo");
		}

		List<Fruteria> frutas = dao.mostrarFrutas();
		List<Carousel> slides = dao.getSlides();

		modelo.addObject("frutas", frutas);
		modelo.addObject("slides", slides);
		modelo.addObject("user", user);
		return modelo;
	}

	@RequestMapping(value = "/carrito")
	public String compraInicio(Model modelo) {
		String redireccion = "";
		if (!user.getNombre().equals("Anónimo")) {
			for (Fruteria precio : carro) {
				precioTotal += precio.getPrecio();
			}
			if (carro.isEmpty()) {
				precioTotal = 0;
			}
			precioTotal = Math.round((double) precioTotal);
			modelo.addAttribute("precio", precioTotal);
			modelo.addAttribute("carro", carro);
			redireccion = "compra";
		}else {
			redireccion = "redirect:login";
		}
		return redireccion;
	}

	@RequestMapping(value = "/carrito/{id}")
	public String carroCompra(@PathVariable int id) {
		carro.add(dao.buscarFruta(id));
		return "redirect:/frontendcontroller/carrito";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarCarro(Model modelo, @PathVariable int id) {
		int i;
		for (i = 0; i < carro.size(); i++) {
			if (carro.get(i).getId() == id) {
				precioTotal -= carro.get(i).getPrecio();
				break;
			}
		}
		carro.remove(i);
		precioTotal = Math.round((double) precioTotal);
		modelo.addAttribute("precio", precioTotal);
		return "redirect:/frontendcontroller/carrito";
	}

	@RequestMapping(value = "/categorias")
	public ModelAndView listadoCategoria(@RequestParam("categoria") String categoria) {
		List<Fruteria> frutas = dao.porCategorias(categoria);
		List<Carousel> slides = dao.getSlides();
		ModelAndView modelo = new ModelAndView("frontendHome");
		modelo.addObject("frutas", frutas);
		modelo.addObject("slides", slides);
		return modelo;
	}

	@RequestMapping(value = "/correo")
	public String enviarCorreo() throws MessagingException {
		// con fichero adjunto
		MimeMessage message2 = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message2, true);
		helper.setTo(user.getEmail());
		helper.setSubject("Frutería Lupo Xan");
		helper.setText("Factura de la compra");

		FileSystemResource file = new FileSystemResource(new File("c://factura.pdf"));
		helper.addAttachment("Invoice", file);

		emailSender.send(message2);
		return "redirect:/frontendcontroller/home";
	}

	@RequestMapping(value = "/pdf")
	public void cargarPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {

		final ServletContext servletContext = request.getSession().getServletContext();
		final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		final String temperotyFilePath = tempDirectory.getAbsolutePath();

		String fileName = "Factura.pdf";
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);

		try {

			CreatePDF.createPDF(temperotyFilePath + "\\" + fileName, carro);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "\\" + fileName);
			ServletOutputStream os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) {

		FileInputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {

			inputStream = new FileInputStream(fileName);
			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();

			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos;
	}

}
