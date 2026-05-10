/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model.dao;

import br.edu.fei.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kamil
 */
public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Usuario usuario) throws SQLException{
        String sql = "INSERT INTO usuario (nome, sobrenome, data_nascimento, cpf, email, nome_usuario, senha))"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getSobrenome());
        statement.setString(3, usuario.getDataNascimento());
        statement.setString(4, usuario.getCpf());
        statement.setString(5, usuario.getEmail());
        statement.setString(6, usuario.getNomeUsuario());
        statement.setString(7, usuario.getSenha());
        
        System.out.println("Executando: " + sql);
        
        statement.execute();
        conn.close();
    }
}
