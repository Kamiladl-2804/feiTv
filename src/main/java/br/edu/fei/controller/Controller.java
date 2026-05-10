/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller;

import br.edu.fei.view.LoginJFrame;
import br.edu.fei.view.CadastroJFrame;
import br.edu.fei.model.Usuario;
import br.edu.fei.model.dao.UsuarioDAO;
import br.edu.fei.model.dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author kamil
 */
public class Controller {
    private CadastroJFrame cadastroView;
    private UsuarioDAO alunoDAO;

    public Controller(CadastroJFrame cadastroView) throws SQLException {
        this.cadastroView = cadastroView;
        Conexao conexao = new Conexao();
        this.alunoDAO = new UsuarioDAO(conexao.getConnection());
    }
    
    public void inserir(){
        String nome = this.cadastroView.getTfNome(); 
        String usuario = this.cadastroView.getTfUsuarioCadastro(); 
        String senha = this.cadastroView.getTfSenha(); 

        Usuario aluno = new Usuario(nome, usuario, senha);
        try{
            this.alunoDAO.inserir(aluno);
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao inserir");
        }
    }
    
}
