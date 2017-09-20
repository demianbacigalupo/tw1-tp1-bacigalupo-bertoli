package ar.edu.unlam.tallerweb1.tp1;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class Ejercicio3Test extends SpringTest{

	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback(true)
	public void testFarmaciasDeUnaCalle() {
		Farmacia farmacia1, farmacia2, farmacia3;
		Direccion direccion1, direccion2, direccion3;
		Barrio barrio1, barrio2;
		Session session;
		
		farmacia1 = new Farmacia();
		farmacia2 = new Farmacia();
		farmacia3 = new Farmacia();
		
		barrio1 = new Barrio();
		barrio2 = new Barrio();
		
		direccion1 = new Direccion();
		direccion2 = new Direccion(); 
		direccion3 = new Direccion();
		
		session = getSession();
		
		barrio1.setNombre("Capital");
		barrio2.setNombre("Provincia");
		
		direccion1.setCalle("Fake Street");
		direccion2.setCalle("Rivadavia");
		direccion3.setCalle("Fake Street");
		
		direccion1.setNumero("123");
		direccion2.setNumero("2006");
		direccion3.setNumero("123");
		
		direccion1.setBarrio(barrio1);
		direccion2.setBarrio(barrio2);
		direccion3.setBarrio(barrio1);
		
		farmacia1.setDireccion(direccion1);
		farmacia2.setDireccion(direccion2);
		farmacia3.setDireccion(direccion3);
		
		session.save(farmacia1);
		session.save(farmacia2);
		session.save(farmacia3);
		session.save(barrio1);
		session.save(barrio2);
		session.save(direccion1);
		session.save(direccion2);
		session.save(direccion3);
		
		List<Farmacia> resultado;
		
		resultado = session.createCriteria(Farmacia.class)
					.createAlias("direccion", "Dir")
					.add(Restrictions.eq("Dir.calle", "Fake Street"))
					.list();
		
		assertThat(resultado).hasSize(2);
	}

}
