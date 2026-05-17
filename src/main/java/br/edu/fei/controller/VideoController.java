/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller;

import br.edu.fei.model.dao.CurtirDAO;
import br.edu.fei.model.Video;
import br.edu.fei.model.dao.CurtirDAO;
import br.edu.fei.model.dao.VideoDAO;
import br.edu.fei.view.PrincipalJFrame;
import java.util.ArrayList;

/**
 *
 * @author kamila
 * Controller responsável por gerenciar as regras relacionadas aos videos.
 */
public class VideoController {
    private final CurtirDAO dao; //DAO que cuida de curtidas
    private final VideoDAO videoDAO; //DAO que cuida dos vídeos
    
    //Construtor do controller. Usa o DAO de curtidas
    public VideoController() {

        dao = new CurtirDAO();
        videoDAO = new VideoDAO();
    }

    //Lista todos os vídeos
    public ArrayList<Video> listarVideos() {

        return videoDAO.listarVideos();
    }

    //Verifica se o usuário curtiu o vídeo
    public boolean usuarioCurtiu(
            int usuarioId,
            int videoId
    ) {

        return dao.usuarioCurtiu(usuarioId, videoId);
    }
    
    //Marca como curtido
    public void curtirVideo(PrincipalJFrame tela) {

        int linha = tela.getTblVideos().getSelectedRow();

        if (linha == -1) {

            tela.mostrarMensagem(
                    "Selecione um vídeo!"
            );

            return;
        }

        int videoId =
                (int) tela.getTblVideos().getValueAt(linha, 0);

        dao.curtirVideo(
                tela.getUsuarioId(),
                videoId
        );

        tela.listarVideosTela();
    }

    //Remove curtida
    public void descurtirVideo(PrincipalJFrame tela) {

        int linha = tela.getTblVideos().getSelectedRow();

        if (linha == -1) {

            tela.mostrarMensagem(
                    "Selecione um vídeo!"
            );

            return;
        }

        int videoId =
                (int) tela.getTblVideos().getValueAt(linha, 0);

        dao.descurtirVideo(
                tela.getUsuarioId(),
                videoId
        );

        tela.listarVideosTela();
    }
    
    //Busca vídeos pelo título
    public ArrayList<Video> buscarVideosPorNome(String titulo) {

        VideoDAO dao = new VideoDAO();

        return dao.buscarVideosPorNome(titulo);
    }
}
