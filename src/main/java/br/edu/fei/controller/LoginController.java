/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller;

import br.edu.fei.model.Usuario;
import br.edu.fei.model.dao.UsuarioDAO;

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
}

