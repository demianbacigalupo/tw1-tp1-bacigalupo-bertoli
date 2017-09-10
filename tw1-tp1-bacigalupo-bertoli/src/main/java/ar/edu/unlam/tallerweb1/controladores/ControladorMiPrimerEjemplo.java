package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorMiPrimerEjemplo {
	@RequestMapping ("/miprimerejemplo")
	public ModelAndView irAMiPrimerEjemplo(){
		ModelMap modelo = new ModelMap();
		String nombreIngresado = "Pepe";
		modelo.put("nombreEnLaVista" ,nombreIngresado);
		return new ModelAndView("miPrimerEjemplo", modelo);
	}
	@RequestMapping ("/misegundoejemplo")
	public ModelAndView irAMiSegundoEjemplo(){
		ModelMap modelo = new ModelMap();
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Hola");
		lista.add("como");
		lista.add("te");
		lista.add("va");
		modelo.put("listaEnLaVista", lista);
		return new ModelAndView("miSegundoEjemplo", modelo);
	}

}
