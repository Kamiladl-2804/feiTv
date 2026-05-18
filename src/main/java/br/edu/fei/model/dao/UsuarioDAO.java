/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model.dao;

import br.edu.fei.model.dao.Conexao;
import br.edu.fei.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kamil
 * DAO das ações de usuario
 */

public class UsuarioDAO {
    //cadastro
    public void cadastrarUsuario(Usuario usuario) {

        String sql =
                "INSERT INTO usuarios(nome, email, senha) VALUES (?, ?, ?)";
        //conexao com o banco
        try (

                Connection conn = Conexao.getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {
            //parametros que ja foram definidos no model
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            //executa
            int linhas = stmt.executeUpdate();
            //coloquei para garantir que foi, ele retona sempre com 1 por que é o numero de linhas para salvar usuario
            System.out.println("Linhas afetadas: " + linhas);
            //avisa para o usuario que ele cadastrou
            System.out.println("Usuário cadastrado!");
            //caso de erro
        } catch (Exception e) {

            System.out.println(
                    "Erro ao cadastrar: " + e.getMessage()
            );
        }
    }
    //login
    public Usuario logar(String email, String senha) {

        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
        //conexao do bando
        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            //busca o e-mail e a senha
            stmt.setString(1, email);
            stmt.setString(2, senha);
            //executa
            var rs = stmt.executeQuery();
            
            if (rs.next()) {
                Usuario u = new Usuario();//objeto usuario
                //dados do usuario
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                return u;//retorna
            }
            //para erros
        } catch (Exception e) {
            System.out.println("Erro no login: " + e.getMessage());
        }

        return null;//não loga caso usuario esteja invalido
    }
}
