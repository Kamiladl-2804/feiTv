/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller;

import br.edu.fei.model.Usuario;
import br.edu.fei.model.dao.UsuarioDAO;
import br.edu.fei.view.CadastroJFrame;
import br.edu.fei.view.LoginJFrame;
import br.edu.fei.view.PrincipalJFrame;

/**
 *
 * @author Kamila
 * 
 * Controller responsavel pelo login
 * 
 */

public class LoginController {

    private final UsuarioDAO dao;//DAO presponsável pelo login e cadastro

    /**
     * Construtor do Controller
     * Inicializa o DAO de favoritos.
     */
    public LoginController() {this.dao = new UsuarioDAO();}

    //Faz login do usuario por e-mail e senha
    public Usuario logar(String email, String senha) {
        return dao.logar(email, senha);}
    
    public void irParaCadastro(LoginJFrame telaLogin) {
        CadastroJFrame telaCadastro = new CadastroJFrame();

        telaCadastro.setController(new UsuarioController());

        telaCadastro.setVisible(true);

        telaLogin.dispose();
    }
    
    public void entrar(LoginJFrame tela) {

        String email = tela.getUsuario();
        String senha = tela.getSenha();

        // validação
        if (
                email.isBlank()
                || senha.isBlank()
        ) {

            tela.mostrarMensagem(
                    "Preencha todos os campos!"
            );

            return;
        }

        Usuario usuario =
                dao.logar(email, senha);

        if (usuario != null) {

            tela.mostrarMensagem(
                    "Login realizado com sucesso!"
            );

            PrincipalJFrame principal =
                    new PrincipalJFrame();

            principal.setUsuarioId(
                    usuario.getId()
            );

            principal.setVisible(true);

            tela.dispose();

        } else {

            tela.mostrarMensagem(
                    "Usuário ou senha inválidos!"
            );
        }
    }
}

