package br.edu.fei.model.dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import br.edu.fei.model.dao.Conexao;
import br.edu.fei.model.Video;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author feispkluongo
 */


public class VideoDAO {

    public ArrayList<Video> listarVideos() {

        ArrayList<Video> lista = new ArrayList<>();

        String sql = "SELECT * FROM videos";

        try (
            Connection conn = new Conexao().getConnection();
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
}