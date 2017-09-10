package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import ar.edu.unlam.tallerweb1.modelo.Producto;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class ProductoDaoImpl implements ProductoDao {
	
	@Inject
	private SessionFactory sessionFactory;
	
	public Producto consultaProductosValorMenor1000 (Producto producto){
		final Session session = sessionFactory.getCurrentSession();
		return (Producto) session.createCriteria(Producto.class).
				add(Restrictions.le("Valor", 1000)).
				list();
	}
	
	public Producto consultaProductosSinDescripcion (Producto producto){
		final Session session = sessionFactory.getCurrentSession();
		return (Producto) session.createCriteria(Producto.class).
				add(Restrictions.isNull("Descripcion")).
				list();
	}
	
	public Producto consultaProductosValorMayor100MenorIgual10 (Producto producto){
		final Session session = sessionFactory.getCurrentSession();
		return (Producto) session.createCriteria(Producto.class).
				add(Restrictions.gt("Valor", 100)).
				add(Restrictions.le("Valor",10)).
				list();
	}
	
	public Producto consultaProductosValor33Valor44 (Producto producto){
		final Session session = sessionFactory.getCurrentSession();
		return (Producto) session.createCriteria(Producto.class).
				add(Restrictions.eq("Valor", 33)).
				add(Restrictions.eq("Valor", 44)).
				list();
	}
	
	public Producto consultaProductosOrdenadosValorDescedente (Producto producto){
		final Session session = sessionFactory.getCurrentSession();
		return (Producto) session.createCriteria(Producto.class).
				addOrder(Order.desc("Valor")).
				list();
	}
	
	public Producto consultaProductosDeUsuario (Usuario usuario){
		final Session session = sessionFactory.getCurrentSession();
		return (Producto) session.createCriteria(Producto.class).
				createAlias("Producto.Usuario", "ProductoUsuario").
				add(Restrictions.eq("ProductoUsuario.id", usuario.getId())).
				list();
	}
	
	public Producto consultaProductosDeUsuarioJoseValor100 (Producto producto){
		final Session session = sessionFactory.getCurrentSession();
		return (Producto) session.createCriteria(Producto.class).
				createAlias("Producto.Usuario", "ProductoUsuario").
				add(Restrictions.eq("ProductoUsuario.nombre", "Jose")).
				add(Restrictions.eq("Valor", 100)).
				list();
	}

}
