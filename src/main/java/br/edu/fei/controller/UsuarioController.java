/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller;

import br.edu.fei.model.Usuario;
import br.edu.fei.model.dao.UsuarioDAO;
import br.edu.fei.view.CadastroJFrame;
import br.edu.fei.view.LoginJFrame;

/**
 *
 * @author kamil
 * Controller responsável por gerenciar as regras relacionadas ao usuário.
 */

public class UsuarioController {
    
    //Faz o cadastro do usuário
    public void finalizarCadastro(
            CadastroJFrame tela
        ) {

        String nome = tela.getNome();
        String email = tela.getEmail();
        String senha = tela.getSenha();

        // Validação dos campos
        if (
                nome.isBlank()
                || email.isBlank()
                || senha.isBlank()
        ) {

            tela.mostrarMensagem(
                    "Preencha todos os campos."
            );

            return;
        }

        Usuario usuario =
                new Usuario(nome, email, senha);

        UsuarioDAO dao =
                new UsuarioDAO();

        dao.cadastrarUsuario(usuario);

        tela.mostrarMensagem(
                "Usuário cadastrado!"
        );

        LoginJFrame telaLogin =
                new LoginJFrame();

        telaLogin.setController(
                new LoginController()
        );

        telaLogin.setVisible(true);

        tela.dispose();
    }
    
    public void irParaLogin(
        CadastroJFrame telaCadastro) {

        LoginJFrame telaLogin =
            new LoginJFrame();

        telaLogin.setController(
            new LoginController());

        telaLogin.setVisible(true);

        telaCadastro.dispose();
    }
}
