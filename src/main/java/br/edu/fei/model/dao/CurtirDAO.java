/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author kamil
 */
public class CurtirDAO {
    public void curtirVideo(int usuarioId, int videoId) {

        String sql =
            "INSERT INTO curtidas(usuario_id, video_id) VALUES (?, ?)";

        try (
            Connection conn = new Conexao().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, usuarioId);
            stmt.setInt(2, videoId);

            stmt.executeUpdate();

            System.out.println("Vídeo curtido!");

        } catch (Exception e) {

            System.out.println(
                "Erro ao curtir vídeo: " + e.getMessage()
            );
        }
    }

    public void descurtirVideo(int usuarioId, int videoId) {

        String sql =
            "DELETE FROM curtidas WHERE usuario_id = ? AND video_id = ?";

        try (
            Connection conn = new Conexao().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, usuarioId);
            stmt.setInt(2, videoId);

            stmt.executeUpdate();

            System.out.println("Vídeo descurtido!");

        } catch (Exception e) {

            System.out.println(
                "Erro ao descurtir vídeo: " + e.getMessage()
            );
        }
    }
    
    public boolean usuarioCurtiu(int usuarioId, int videoId) {

        String sql = "SELECT 1 FROM curtidas WHERE usuario_id = ? AND video_id = ?";

        try (
            Connection conn = new Conexao().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, usuarioId);
            stmt.setInt(2, videoId);

            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (Exception e) {
            System.out.println("Erro ao verificar curtida: " + e.getMessage());
        }

        return false;
    }
}
