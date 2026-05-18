package br.edu.fei.model.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import br.edu.fei.model.Video;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author feispkluongo
 * DAO para videos do programa
 */


public class VideoDAO {
    //lista de videos
    public ArrayList<Video> listarVideos() {

        ArrayList<Video> lista = new ArrayList<>();

        String sql = "SELECT * FROM videos";

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                Video video = new Video();

                video.setId(rs.getInt("id"));
                video.setTitulo(rs.getString("titulo"));
                video.setDescricao(rs.getString("descricao"));
                video.setCategoria(rs.getString("categoria"));
                video.setClassificacaoIndicativa(
                        rs.getString("classificacao_indicativa")
                );

                lista.add(video);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar vídeos: " + e.getMessage());
        }

        return lista;
    }
    /**
     * 
     * @param titulo
     * @return 
     */
    public ArrayList<Video> buscarVideosPorNome(String titulo) {

        ArrayList<Video> lista = new ArrayList<>();

        String sql =
            "SELECT * FROM videos WHERE titulo ILIKE ?";
        
        //Conecta e consulta 
        try (
                
            Connection conn =  Conexao.getConnection();

            PreparedStatement stmt =
                    conn.prepareStatement(sql)

        ) {
            //retorno e executar
            stmt.setString(1, "%" + titulo + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Video video = new Video();//objeto 
                //dados de video
                video.setId(rs.getInt("id"));
                video.setTitulo(rs.getString("titulo"));
                video.setDescricao(rs.getString("descricao"));
                video.setCategoria(rs.getString("categoria"));
                video.setClassificacaoIndicativa(
                     rs.getString("classificacao_indicativa")
                );
                
                //adiciona o video da lista
                lista.add(video);
            }
            //se não da erro
        } catch (Exception e) {

            System.out.println(
                "Erro ao buscar vídeos: " + e.getMessage()
            );
        }
        //retorna a lista
        return lista;
    }
}