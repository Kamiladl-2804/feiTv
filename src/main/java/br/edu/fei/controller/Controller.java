/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller;

import br.edu.fei.model.Aluno;
import br.edu.fei.model.dao.AlunoDAO;
import br.edu.fei.model.dao.Conexao;
import br.edu.fei.view.CadastroJFrame;
import java.sql.SQLException;

/**
 *
 * @author kamil
 */
public class Controller {
    private CadastroJFrame cadastroView;
    private AlunoDAO alunoDAO;

    public Controller(CadastroJFrame cadastroView) throws SQLException {
        this.cadastroView = cadastroView;
        Conexao conexao = new Conexao();
        this.alunoDAO = new AlunoDAO(conexao.getConnection());
    }
    
    public void inserir(){
        String nome = this.cadastroView.getTfNome().getText();
        String usuario = this.cadastroView.getTfUsuario().getText();
        String senha = this.cadastroView.getTfSenha().getText();
        Aluno aluno = new Aluno(nome, usuario, senha);
        try{
            this.alunoDAO.inserir(aluno);
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao inserir");
        }
    }
    
}
