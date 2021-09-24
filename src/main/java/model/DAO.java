package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {

	public void cadastrarFilme() {

		String sql = "INSERT INTO Filmes VALUES (null,?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection conn = null;

		try {
			conn = ((Statement) new MySqlConnection()).getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1,Filme.getTitulo());
			pStatement.setInt(2, Filme.getdescricao());
			pStatement.setString(3, Filme.getGenero());
			pStatement.setDouble(4, Filme.getDuracao());
			pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public ArrayList<> BuscarProdutosPorDescricao(String descricao) {
		String sql = "SELECT * FROM PRODUTO WHERE descricao LIKE '%" + descricao + "%'";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pStatement = null;
		Filme produto = null;
		ArrayList<Filme> Filme = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			if (rs != null) {
				Filme = new ArrayList<Filme>();
				while (rs.next()) {
					produto = new Filme();
					produto.setIdFilme(rs.getInt("idFilme"));
					produto.setDescricao(rs.getString("Filme"));
					produto.setQuantidade(rs.getInt("quantidade"));
					Filme.add(produto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return Filme;
	}

	public void ExcluirFilme(int idProduto, int idFilme) {
		String sql = "DELETE FROM Filme WHERE idFilme = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, idFilme);
			pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void AlterarFilme(Filme produto) {
		String sql = "UPDATE PRODUTO SET descricao = ?, quantidade = ?, preco = ?, onLine = ? WHERE idProduto = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, produto.getDescricao());
			pStatement.setInt(2, produto.getQuantidade());
			pStatement.setInt(5, produto.getIdFilme());
			pStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStatement != null)
					pStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
