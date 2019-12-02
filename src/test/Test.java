package test;

import java.util.Calendar;

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

		UsuarioController.get(null);
	}
}