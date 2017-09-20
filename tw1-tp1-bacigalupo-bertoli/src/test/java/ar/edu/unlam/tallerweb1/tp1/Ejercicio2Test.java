package ar.edu.unlam.tallerweb1.tp1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class Ejercicio2Test extends SpringTest{

	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback(true)
	public void farmaciasDeMartes() {
		Farmacia f1 = new Farmacia("Farmacia1","4412-3223","lunes");
		Farmacia f2 = new Farmacia("Farmacia2","4412-1223","martes");
		Farmacia f3 = new Farmacia("Farmacia3","4412-3423","martes");
		Farmacia f4 = new Farmacia("Farmacia4","4412-8623","jueves");
		
		getSession().save(f1);
		assertThat(getSession().get(Farmacia.class, f1.getIdFarmacia()));
		
		getSession().save(f2);
		assertThat(getSession().get(Farmacia.class, f2.getIdFarmacia()));
		
		getSession().save(f3);
		assertThat(getSession().get(Farmacia.class, f3.getIdFarmacia()));
		
		getSession().save(f4);
		assertThat(getSession().get(Farmacia.class, f4.getIdFarmacia()));
		
		List<Farmacia> f = getSession().createCriteria(Farmacia.class)
				.add(Restrictions.eq("diaDeTurno", "martes"))
				.list();
		assertThat(f).hasSize(2);
		
	}

}
