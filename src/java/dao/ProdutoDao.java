/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Basic.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import jdbc.ConnectionFactory;

/**
 *
 * @author lucasbighi
 */
public class ProdutoDao {
    private Connection connection;
    
    public ProdutoDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Produto produto){
        String sql = "INSERT INTO produtos " +
                "(nomeCompleto,cpfcnpj,dataNascimento,endereco,nmr,cidade,uf,cep,email,senha)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getPreco());
            stmt.setString(3,  produto.getDescricao());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    	public List<Produto> getLista() {
		try {
			List<Produto> produtos = new ArrayList<Produto>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from produtos");
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				Produto produto = new Produto();
				//popula o objeto produto
                                produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getString("preco"));
				produto.setDescricao(rs.getString("descricao"));

				//adiciona o produto na lista
				produtos.add(produto);
			}

			rs.close();
			stmt.close();

			return produtos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
