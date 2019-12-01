package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Usuario;

public class Test {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("social");
		EntityManager em = emf.createEntityManager();

		Usuario usuario = new Usuario();
		usuario.nome = "José";
		usuario.email = "jose@email.com";
		usuario.senha = "jose";

		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();
	}
}