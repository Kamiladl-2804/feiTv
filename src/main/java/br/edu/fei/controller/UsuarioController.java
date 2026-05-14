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
 * Controller responsável por gerenciar as regras relacionadas ao usuário.
 */

public class UsuarioController {
    
    //Faz o cadastro do usuário
    public void cadastrar(
            String nome,
            String email,
            String senha
    ) {
        //Cria o objeto usuário de acordo com a tabela do banco
        Usuario usuario =
                new Usuario(nome, email, senha);

        UsuarioDAO dao = new UsuarioDAO(); //DAO que puxa a tabela usuario para cadastro e login

        dao.cadastrarUsuario(usuario); //Chama o método cadastro que esta no DAO
    }
}
