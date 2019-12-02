package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue
	public int id;
	public String nome;
	public String email;
	public String login;
	public String senha;
	public Date dataNascimento;
	public Genero genero;
}