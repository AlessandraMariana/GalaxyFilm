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
			pStatement.setDouble(5, Filme.getPreco());
			pStatement.setBoolean(4, Filme.isOnLine());
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
		Produto produto = null;
		ArrayList<Produto> produtos = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			rs = pStatement.executeQuery();
			if (rs != null) {
				produtos = new ArrayList<Produto>();
				while (rs.next()) {
					produto = new Produto();
					produto.setIdProduto(rs.getInt("idProduto"));
					produto.setDescricao(rs.getString("descricao"));
					produto.setQuantidade(rs.getInt("quantidade"));
					produto.setPreco(rs.getDouble("preco"));
					produto.setOnLine(rs.getBoolean("onLine"));
					produtos.add(produto);
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
		return produtos;
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

	public void AlterarFilme(Produto produto) {
		String sql = "UPDATE PRODUTO SET descricao = ?, quantidade = ?, preco = ?, onLine = ? WHERE idProduto = ?";
		PreparedStatement pStatement = null;
		Connection conn = null;
		try {
			conn = new MySqlConnection().getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, produto.getDescricao());
			pStatement.setInt(2, produto.getQuantidade());
			pStatement.setDouble(3, produto.getPreco());
			pStatement.setBoolean(4, produto.isOnLine());
			pStatement.setInt(5, produto.getIdProduto());
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
