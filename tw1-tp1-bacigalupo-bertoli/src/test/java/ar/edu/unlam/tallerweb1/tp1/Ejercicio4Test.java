package ar.edu.unlam.tallerweb1.tp1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class Ejercicio4Test extends SpringTest{

	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback(true)
	public void buscarfarmaciasDeUnBarrio() {
		Farmacia f1 = new Farmacia("Farmacia1","4412-3223","lunes");
		Farmacia f2 = new Farmacia("Farmacia2","4412-1223","martes");
		Farmacia f3 = new Farmacia("Farmacia3","4412-3423","miercoles");
		Farmacia f4 = new Farmacia("Farmacia4","4412-8623","jueves");
		
		Direccion direccion1 = new Direccion();
		Direccion direccion2 = new Direccion();
		Direccion direccion3 = new Direccion();
		Direccion direccion4 = new Direccion();
		Barrio barrio1 = new Barrio("Aldo Bonzi");
		Barrio barrio2 = new Barrio("Ciudad Evita");
		
		direccion1.setBarrio(barrio1);
		direccion2.setBarrio(barrio1);
		direccion3.setBarrio(barrio1);
		direccion4.setBarrio(barrio2);
		
		f1.setDireccion(direccion1);
		f2.setDireccion(direccion2);
		f3.setDireccion(direccion3);
		f4.setDireccion(direccion4);
		
		
		getSession().save(barrio1);
		assertThat(getSession().get(Barrio.class, barrio1.getIdBarrio()));
		
		getSession().save(barrio2);
		assertThat(getSession().get(Barrio.class, barrio1.getIdBarrio()));
		
		getSession().save(direccion1);
		assertThat(getSession().get(Direccion.class, direccion1.getIdDireccion()));
		
		getSession().save(direccion2);
		assertThat(getSession().get(Direccion.class, direccion2.getIdDireccion()));
		
		getSession().save(direccion3);
		assertThat(getSession().get(Direccion.class, direccion3.getIdDireccion()));
		
		getSession().save(direccion4);
		assertThat(getSession().get(Direccion.class, direccion4.getIdDireccion()));
		
		getSession().save(f1);
		assertThat(getSession().get(Farmacia.class, f1.getIdFarmacia()));
		
		getSession().save(f2);
		assertThat(getSession().get(Farmacia.class, f2.getIdFarmacia()));
		
		getSession().save(f3);
		assertThat(getSession().get(Farmacia.class, f3.getIdFarmacia()));
		
		getSession().save(f4);
		assertThat(getSession().get(Farmacia.class, f4.getIdFarmacia()));
		
		List<Farmacia> f = getSession().createCriteria(Farmacia.class)
				.createAlias("direccion", "dir")
				.createAlias("dir.barrio", "barrio")
				.add(Restrictions.eq("barrio.nombre", "Aldo Bonzi"))
				.list();
		assertThat(f).hasSize(3);
				
				
	}
 
}
