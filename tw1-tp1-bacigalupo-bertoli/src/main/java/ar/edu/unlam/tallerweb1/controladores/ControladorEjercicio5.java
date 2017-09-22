package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorEjercicio5 {
	@RequestMapping("/sumar/{numero1}/{numero2}")
	public ModelAndView sumar(@PathVariable("numero1") String num1 ,@PathVariable("numero2") String num2) throws Exception{
		try {
		Integer a = Integer.valueOf((String) num1);
		Integer b = Integer.valueOf((String) num2);
		Integer num3;
		String operacion = "sumar";
		ModelMap modelo = new ModelMap();
		modelo.put("numsum1", a);
		modelo.put("numsum2", b);
		num3 = a + b;
		modelo.put("numres3", num3);
		modelo.put("operacion", operacion);
		return new ModelAndView("ejercicio5", modelo);
			
		} catch (Exception e) {
			ModelMap modelo = new ModelMap();
			modelo.put("invalido", "No se puede hacer la operacion");
			return new ModelAndView("operacionInvalida",modelo);
		}
	}
	@RequestMapping("/restar/{numero1}/{numero2}")
	public ModelAndView restar(@PathVariable("numero1") String num1 ,@PathVariable("numero2") String num2) throws Exception{
		try {
		Integer a = Integer.valueOf((String) num1);
		Integer b = Integer.valueOf((String) num2);
		Integer num3;
		String operacion = "restar";
		ModelMap modelo = new ModelMap();
		modelo.put("numsum1", a);
		modelo.put("numsum2", b);
		num3 = a - b;
		modelo.put("numres3", num3);
		modelo.put("operacion", operacion);
		return new ModelAndView("ejercicio5", modelo);
			
		} catch (Exception e) {
			ModelMap modelo = new ModelMap();
			modelo.put("invalido", "No se puede hacer la operacion");
			return new ModelAndView("operacionInvalida",modelo);
		}
	}
	@RequestMapping("/multiplicar/{numero1}/{numero2}")
	public ModelAndView multiplicar(@PathVariable("numero1") String num1 ,@PathVariable("numero2") String num2) throws Exception{
		try {
		Integer a = Integer.valueOf((String) num1);
		Integer b = Integer.valueOf((String) num2);
		Integer num3;
		String operacion = "multiplicar";
		ModelMap modelo = new ModelMap();
		modelo.put("numsum1", a);
		modelo.put("numsum2", b);
		num3 = a * b;
		modelo.put("numres3", num3);
		modelo.put("operacion", operacion);
		return new ModelAndView("ejercicio5", modelo);
			
		} catch (Exception e) {
			ModelMap modelo = new ModelMap();
			modelo.put("invalido", "No se puede hacer la operacion");
			return new ModelAndView("operacionInvalida",modelo);
		}
	}
	@RequestMapping("/dividir/{numero1}/{numero2}")
	public ModelAndView dividir(@PathVariable("numero1") String num1 ,@PathVariable("numero2") String num2) throws Exception{
		try {
		Integer a = Integer.valueOf((String) num1);
		Integer b = Integer.valueOf((String) num2);
		Integer num3;
		String operacion = "dividir";
		ModelMap modelo = new ModelMap();
		modelo.put("numsum1", a);
		modelo.put("numsum2", b);
		num3 = a / b;
		modelo.put("numres3", num3);
		modelo.put("operacion", operacion);
		return new ModelAndView("ejercicio5", modelo);
			
		} catch (Exception e) {
			ModelMap modelo = new ModelMap();
			modelo.put("invalido", "No se puede hacer la operacion");
			return new ModelAndView("operacionInvalida",modelo);
		}
	}
	@RequestMapping("/rutaInvalida")
	public ModelAndView rutaInvalida() {
		String mensajeError = "La ruta es invalida";
		ModelMap modelo = new ModelMap();
		modelo.put("error", mensajeError);
		
		return new ModelAndView("paginaNoEncontrada", modelo);
	}
	
}
