package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.Usuario;

public class UsuarioController {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("social");
	EntityManager em = emf.createEntityManager();

	public void save(Usuario u) {
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		emf.close();
	}

	public List<Usuario> get(Usuario u) {
		em.getTransaction().begin();
		if (u == null) {
			var q = em.createQuery("select usuario from usuarios");
			var lista = q.getResultList();
			em.getTransaction().commit();
			emf.close();
			return lista;
		} else {
			var q = em.createQuery("select usuario from usuarios where id = " + u.id);
			var lista = q.getResultList();
			emf.close();
			return lista;
		}
	}

	public void delete(Usuario u) {
		em.getTransaction().begin();
		Query q = em.createNativeQuery("delete usuario from usuarios where id = " + u.id);
		em.getTransaction().commit();
		emf.close();
	}
}
