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
 * responsável pela ação de curtida
 */
public class CurtirDAO {
    //adiciona a curtida do usuario
    public void curtirVideo(int usuarioId, int videoId) {

        String sql =
            "INSERT INTO curtidas(usuario_id, video_id) VALUES (?, ?)";

        try (
            Connection conn = Conexao.getConnection(); //conecta com o banco
            PreparedStatement stmt = conn.prepareStatement(sql) //SQL
        ) {

            //parametros para salvar
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, videoId);

            //executa
            stmt.executeUpdate();

            //mensagem para o usuario
            System.out.println("Vídeo curtido!");
            
         //em caso de problemas   
        } catch (Exception e) {

            System.out.println(
                "Erro ao curtir vídeo: " + e.getMessage()
            );
        }
    }
    
    //descurtir video
    public void descurtirVideo(int usuarioId, int videoId) {

        String sql =
            "DELETE FROM curtidas WHERE usuario_id = ? AND video_id = ?";

        try (
            Connection conn = Conexao.getConnection(); //conexao com banco
            PreparedStatement stmt = conn.prepareStatement(sql)//SQL
        ) {
            //parametros
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, videoId);
            
            //executa
            stmt.executeUpdate();
            
            //mensagem que funcionou
            System.out.println("Vídeo descurtido!");
         
         //em casos de problemas
        } catch (Exception e) {

            System.out.println(
                "Erro ao descurtir vídeo: " + e.getMessage()
            );
        }
    }
    
    //Olhar se o usuario curtiu o video, importante para exibir curtida
    public boolean usuarioCurtiu(int usuarioId, int videoId) {

        String sql = "SELECT 1 FROM curtidas WHERE usuario_id = ? AND video_id = ?";

        try (
            Connection conn =  Conexao.getConnection(); //conexao com o banco
            PreparedStatement stmt = conn.prepareStatement(sql) //SQL
        ) {
            //parametros
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, videoId);
            
            //consulta
            ResultSet rs = stmt.executeQuery();
            
            //mostra como verdadeiro se tiver a curtida
            return rs.next();
            
         //para caso de problemas
        } catch (Exception e) {
            System.out.println("Erro ao verificar curtida: " + e.getMessage());
        }

        return false;
    }
}
