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
 */

public class UsuarioDAO {
    public void cadastrarUsuario(Usuario usuario) {

        String sql =
                "INSERT INTO usuarios(nome, email, senha) VALUES (?, ?, ?)";

        try (

                Connection conn = new Conexao().getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)

        ) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());

            stmt.execute();

            System.out.println("Usuário cadastrado!");

        } catch (Exception e) {

            System.out.println(
                    "Erro ao cadastrar: " + e.getMessage()
            );
        }
    }
    
    public Usuario logar(String email, String senha) {

        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";

        try (
            Connection conn = new Conexao().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            var rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                return u;
            }

        } catch (Exception e) {
            System.out.println("Erro no login: " + e.getMessage());
        }

        return null;
    }
}
