/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model.dao;

import java.sql.SQLException;
import br.edu.fei.model.Video;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author kamil
 * DAO para os dados de favoritos 
 */
public class FavoritosDAO {
   private final Connection conn; //conexao com o banco
   //construtor de conexao
    public FavoritosDAO() {
        try {

            this.conn = new Conexao().getConnection();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
    //busca uma lista ja existente (caso exista ele retorna verdadeiro)
    public boolean existeLista(int usuarioId) {
        String sql = "SELECT id FROM favoritos WHERE usuario_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            return rs.next();
           //caso não tenha a lista
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //criar lista de favoritos
    public void criarLista(int usuarioId) {
        String sql = "INSERT INTO favoritos (usuario_id) VALUES (?)";
        //conecta e busca no banco
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            //procura oelo usuario pelo ID de quem esta logado no momento
            stmt.setInt(1, usuarioId);
            stmt.executeUpdate();
          //para erros
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //adicionar o video na lista
    public void adicionarVideo(int usuarioId, int videoId) {

        String sql = """
            INSERT INTO favoritos_video (favorito_id, video_id)
            VALUES (
                (SELECT id FROM favoritos WHERE usuario_id = ?),
                ?
            )
        """;
        //prepara o banco e salva o ID do usuario e do video
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            stmt.setInt(2, videoId);

            stmt.executeUpdate();
            //caso de erro
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //remover video
    public void removerVideo(int usuarioId, int videoId) {

        String sql = """
            DELETE FROM favoritos_video
            WHERE favorito_id = (SELECT id FROM favoritos WHERE usuario_id = ?)
            AND video_id = ?
        """;
        //conecta e olha o ID de usuario e video
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            stmt.setInt(2, videoId);

            stmt.executeUpdate();
            //caso de erro
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   //excluir lista 
    public void excluirLista(int usuarioId) {

        String sql = "DELETE FROM favoritos WHERE usuario_id = ?";
        //conecta e olha quem esta logado para excluir a lista dele
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            stmt.executeUpdate();
            //caso de erro
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //como salva a lista
    public List<Video> listarFavoritos(int usuarioId) {

        List<Video> lista = new ArrayList<>();//lista que vai salvar

        String sql = """
            SELECT v.id, v.titulo, v.descricao, v.categoria, v.classificacao_indicativa
            FROM videos v
            INNER JOIN favoritos_video fv ON fv.video_id = v.id
            INNER JOIN favoritos f ON f.id = fv.favorito_id
            WHERE f.usuario_id = ?
        """;
        //chama o banco e salva pelo usuario logado
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //criar o objeto e o que salva no na lista(usei só v para eu saber do que se trata e não usar video para tudo, como foi uma das ultimas coisas a ser adicionadao no banco eu não queria me perder)
                Video v = new Video();
                v.setId(rs.getInt("id"));
                v.setTitulo(rs.getString("titulo"));
                v.setDescricao(rs.getString("descricao"));
                v.setCategoria(rs.getString("categoria"));
                v.setClassificacaoIndicativa(rs.getString("classificacao_indicativa"));
                //adiciona video
                lista.add(v);
            }
            //caso de erro
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //retorna a lista
        return lista;
    } 
}
