/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller;

import br.edu.fei.model.Usuario;
import br.edu.fei.model.dao.UsuarioDAO;

/**
 *
 * @author feispkluongo
 */



public class LoginController {

    private UsuarioDAO dao;

    public LoginController() {
        this.dao = new UsuarioDAO();
    }

    public Usuario logar(String email, String senha) {
        return dao.logar(email, senha);
    }
}

