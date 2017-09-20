package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorEjercicio5 {
	@RequestMapping("/ejercicio5")
	public ModelAndView Saludar(@PathVariable("numero1") String num1,@RequestParam("numero2") String num2){
		String num3;
		ModelMap modelo = new ModelMap();
		modelo.addAttribute("numsum1", num1);
		modelo.addAttribute("numsum2", num2);
		num3 = num1 + num2;
		modelo.addAttribute("numres3", num3);
		return new ModelAndView("ejercicio5", modelo);
	}
}
