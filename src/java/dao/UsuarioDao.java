/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Basic.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.ConnectionFactory;

/**
 *
 * @author lucasbighi
 */
public class UsuarioDao {
    private Connection connection;
    
    public UsuarioDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Usuario usuario){
        String sql = "INSERT INTO usuarios " +
                "(nomeCompleto,cpfcnpj,dataNascimento,endereco,nmr,cidade,uf,cep,email,senha)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, usuario.getNomeCompleto());
            stmt.setString(2, usuario.getCpfcnpj());
            stmt.setDate(3,  new Date(usuario.getDataNascimento().getTimeInMillis()));
            stmt.setString(4, usuario.getEndereco());
            stmt.setString(5, usuario.getNrm());
            stmt.setString(6, usuario.getCidade());
            stmt.setString(7, usuario.getUf());
            stmt.setString(8, usuario.getCep());
            stmt.setString(9, usuario.getEmail());
            stmt.setString(10, usuario.getSenha());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
