package data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UsuarioCadastro")
public class UsuarioCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioCadastro() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter printer = response.getWriter();

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nascimento = request.getParameter("nascimento");
		String genero = request.getParameter("gender");

		Date n = Date.valueOf(nascimento);

		String sql = "insert into usuarios (nome, email, login, senha, nascimento, genero) "
				+ "values (?, ?, ?, ?, ?, ?)";

		printer.println("<p><a href=\"index.html\">Início</a></p>");

		try {
			Connection con = ConnectionFactory.createConnection();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, nome);
			stm.setString(2, email);
			stm.setString(3, login);
			stm.setString(4, senha);
			stm.setDate(5, n);
			stm.setString(6, genero);

			if (stm.executeUpdate() > 0)
				printer.println("Usuário salvo com sucesso");
			else
				printer.println("Erro ao salvar");

			con.close();
		} catch (SQLException e) {

			printer.println("Erro ao salvar");
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
