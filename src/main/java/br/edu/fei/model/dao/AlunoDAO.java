/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model.dao;

import br.edu.fei.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kamil
 */
public class AlunoDAO {
    private Connection conn;

    public AlunoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Aluno aluno) throws SQLException{
        String sql = "INSERT INTO aluno(nome, usuario, senha)"
                + "values('"  + aluno.getNome() +"', '" +
                aluno.getUsuario() + "', '" + aluno.getSenha() + "')";
        System.out.println(sql);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
}
