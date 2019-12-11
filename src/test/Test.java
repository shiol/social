package test;

import java.util.Calendar;
import java.util.List;

import controller.UsuarioController;
import data.Util;
import domain.Genero;
import domain.Usuario;

public class Test {

	public static void main(String[] args) {

		Usuario usuario = new Usuario();
		usuario.nome = Util.randomString(10);
		usuario.login = Util.randomString(10);
		usuario.email = Util.randomString(5) + "@" + Util.randomString(5) + ".com";
		usuario.senha = Util.randomString(5);
		usuario.genero = Util.randomBetween(0, 1) == 0 ? Genero.Masculino : Genero.Feminino;
		var calendar = Calendar.getInstance();
		calendar.set(Util.randomBetween(1960, 2010), Util.randomBetween(0, 11), Util.randomBetween(1, 28));
		usuario.dataNascimento = calendar.getTime();

		UsuarioController.save(usuario);

		List<Usuario> result = UsuarioController.get(null);
		for (Usuario u : result) {
			System.out.println(u.id);
			System.out.println(u.nome);
			System.out.println(u.email);
			System.out.println(u.login);
			System.out.println(u.dataNascimento);
			System.out.println(u.genero);
			System.out.println();
		}

		var t = new Usuario();
		t.id = result.get(0).id;
		result = UsuarioController.get(t);
		for (Usuario u : result) {
			System.out.println(u.id);
			System.out.println(u.nome);
			System.out.println(u.email);
			System.out.println(u.login);
			System.out.println(u.dataNascimento);
			System.out.println(u.genero);
			System.out.println();
		}

		UsuarioController.delete(t);
	}
}