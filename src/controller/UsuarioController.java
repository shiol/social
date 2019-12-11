package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Usuario;

public class UsuarioController {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("social");
	static EntityManager em = emf.createEntityManager();

	public static void save(Usuario u) {
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public static List<Usuario> get(Usuario u) {
		List<Usuario> lista;
		if (u == null) {
			var result = em.createQuery("from Usuario u");
			lista = result.getResultList();
		} else {
			var result = em.createQuery("from Usuario u where u.id = " + u.id);
			lista = result.getResultList();
		}
		return lista;
	}

	public static void delete(Usuario u) {
		em.getTransaction().begin();
		var result = em.find(Usuario.class, u.id);
		em.remove(result);
		em.getTransaction().commit();
	}
}
