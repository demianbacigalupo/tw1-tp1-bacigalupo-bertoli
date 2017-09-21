package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorEjercicio5 {
	@RequestMapping("/ejercicio5/{numero1}/{numero2}")
	public ModelAndView Saludar(@PathVariable("numero1") String num1 ,@PathVariable("numero2") String num2) throws Exception{
		try {
		Integer a = Integer.valueOf((String) num1);
		Integer b = Integer.valueOf((String) num2);
		Integer num3;
		ModelMap modelo = new ModelMap();
		modelo.put("numsum1", a);
		modelo.put("numsum2", b);
		num3 = a + b;
		modelo.put("numres3", num3);
		return new ModelAndView("ejercicio5", modelo);
			
		} catch (Exception e) {
			ModelMap modelo = new ModelMap();
			modelo.put("invalido", "No se puede hacer la operacion");
			return new ModelAndView("operacionInvalida",modelo);
		}
	}
}
