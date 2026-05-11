/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller;

import br.edu.fei.model.Usuario;
import br.edu.fei.model.dao.UsuarioDAO;
import br.edu.fei.model.dao.Conexao;
import br.edu.fei.view.CadastroJFrame;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author kamil
 */
public class CadastroController {
    private CadastroJFrame cadastroView;
    private UsuarioDAO usuarioDAO;

    public CadastroController(CadastroJFrame cadastroView) throws SQLException {
        this.cadastroView = cadastroView;
        Conexao conexao = new Conexao();
        this.UsuarioDAO = new UsuarioDAO(conexao.getConnection());
    }
    
    public void inserir(){
        String nome = this.cadastroView.getTfNome().getText();
        String usuario = this.cadastroView.getTfUsuario().getText();
        String senha = this.cadastroView.getTfSenha().getText();
        Usuario usuario = new Usuario(nome, usuario, senha);
        try{
            this.UsuarioDAO.inserir(usuario);
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao inserir");
        }
    }
    
}
