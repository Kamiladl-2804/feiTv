/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model.dao;

import br.edu.fei.model.Video;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author kamil
 */
public class FavoritosDAO {
   private Connection conn;

    public FavoritosDAO() {
        this.conn = Conexao.getConexao();
    }

    public boolean existeLista(int usuarioId) {
        String sql = "SELECT id FROM favoritos WHERE usuario_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void criarLista(int usuarioId) {
        String sql = "INSERT INTO favoritos (usuario_id) VALUES (?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void adicionarVideo(int usuarioId, int videoId) {

        String sql = """
            INSERT INTO favoritos_video (favorito_id, video_id)
            VALUES (
                (SELECT id FROM favoritos WHERE usuario_id = ?),
                ?
            )
        """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            stmt.setInt(2, videoId);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removerVideo(int usuarioId, int videoId) {

        String sql = """
            DELETE FROM favoritos_video
            WHERE favorito_id = (SELECT id FROM favoritos WHERE usuario_id = ?)
            AND video_id = ?
        """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            stmt.setInt(2, videoId);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   
    public void excluirLista(int usuarioId) {

        String sql = "DELETE FROM favoritos WHERE usuario_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Video> listarFavoritos(int usuarioId) {

        List<Video> lista = new ArrayList<>();

        String sql = """
            SELECT v.id, v.titulo, v.descricao, v.categoria, v.classificacao_indicativa
            FROM videos v
            INNER JOIN favoritos_video fv ON fv.video_id = v.id
            INNER JOIN favoritos f ON f.id = fv.favorito_id
            WHERE f.usuario_id = ?
        """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Video v = new Video();
                v.setId(rs.getInt("id"));
                v.setTitulo(rs.getString("titulo"));
                v.setDescricao(rs.getString("descricao"));
                v.setCategoria(rs.getString("categoria"));
                v.setClassificacaoIndicativa(rs.getString("classificacao_indicativa"));

                lista.add(v);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    } 
}
