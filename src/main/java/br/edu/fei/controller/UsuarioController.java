/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller;

import br.edu.fei.model.Usuario;
import br.edu.fei.model.dao.UsuarioDAO;

/**
 *
 * @author kamil
 */

public class UsuarioController {

    public void cadastrar(
            String nome,
            String email,
            String senha
    ) {

        Usuario usuario =
                new Usuario(nome, email, senha);

        UsuarioDAO dao = new UsuarioDAO();

        dao.cadastrarUsuario(usuario);
    }
}
