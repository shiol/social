package data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UsuarioLista")
public class UsuarioLista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioLista() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter printer = response.getWriter();
		String sql = "select * from usuarios";

		printer.println("<p><a href=\"index.html\">Início</a></p>");

		try {
			Connection con = ConnectionFactory.createConnection();
			ResultSet result = con.createStatement().executeQuery(sql);

			while (result.next()) {

				printer.println("id: " + result.getInt("id") + "<br>");
				printer.println("nome: " + result.getString("nome") + "<br>");
				printer.println("e-mail: " + result.getString("email") + "<br>");
				printer.println("login: " + result.getString("login") + "<br>");
				printer.println("nascimento: " + result.getDate("nascimento") + "<br>");
				printer.println("gênero: " + result.getString("genero") + "<br>");
				printer.println("<br>");
			}

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
