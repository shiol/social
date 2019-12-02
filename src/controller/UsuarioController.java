package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.Usuario;

public class UsuarioController {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("social");
	static EntityManager em = emf.createEntityManager();

	public static void save(Usuario u) {
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
	}

	public static List<Usuario> get(Usuario u) {
		em.getTransaction().begin();
		if (u == null) {
			var q = em.createQuery("select usuario from usuarios usuario");
			var lista = q.getResultList();
			em.getTransaction().commit();
			return lista;
		} else {
			var q = em.createQuery("select usuario from usuarios usuario where usuario.id = " + u.id);
			var lista = q.getResultList();
			return lista;
		}
	}

	public static void delete(Usuario u) {
		em.getTransaction().begin();
		Query q = em.createNativeQuery("delete usuario from usuarios where id = " + u.id);
		em.getTransaction().commit();
		emf.close();
	}
}
