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
import java.util.List;

/**
 *
 * @author kamila
 * Controller responsável por gerenciar as regras relacionadas aos videos.
 */
public class VideoController {
    private final CurtirDAO curtirDAO; //DAO que cuida de curtidas
    private final VideoDAO videoDAO; //DAO que cuida dos vídeos
    
    //Construtor do controller. Usa o DAO de curtidas
    public VideoController() {

        this.videoDAO = new VideoDAO();
        this.curtirDAO = new CurtirDAO();
    }

    //Lista todos os vídeos
    public ArrayList<Video> listarVideos() {
        return videoDAO.listarVideos();
    }

    public boolean usuarioCurtiu(int usuarioId, int videoId) {
        return curtirDAO.usuarioCurtiu(usuarioId, videoId);
    }

    public ArrayList<Video> buscarVideosPorNome(String titulo) {
        return videoDAO.buscarVideosPorNome(titulo);
    }

    public void curtirVideo(PrincipalJFrame tela) {

        int linha = tela.getTblVideos().getSelectedRow();

        if (linha == -1) {
            tela.mostrarMensagem("Selecione um vídeo!");
            return;
        }

        int videoId = (int) tela.getTblVideos().getValueAt(linha, 0);

        if (tela.getUsuarioId() <= 0) {
            tela.mostrarMensagem("Usuário inválido!");
            return;
        }

        curtirDAO.curtirVideo(tela.getUsuarioId(), videoId);

        tela.mostrarMensagem("Vídeo curtido");

        tela.listarVideosTela();
    }

   
    public void descurtirVideo(PrincipalJFrame tela) {

        int linha = tela.getTblVideos().getSelectedRow();

        if (linha == -1) {
            tela.mostrarMensagem("Selecione um vídeo!");
            return;
        }

        int videoId = (int) tela.getTblVideos().getValueAt(linha, 0);

        if (tela.getUsuarioId() <= 0) {
            tela.mostrarMensagem("Usuário inválido!");
            return;
        }

        curtirDAO.descurtirVideo(tela.getUsuarioId(), videoId);

        tela.mostrarMensagem("Curtida removida");

        tela.listarVideosTela();
    }

    
    public List<Object[]> listarVideosParaTabela(int usuarioId) {

        ArrayList<Video> lista = videoDAO.listarVideos();
        List<Object[]> resultado = new ArrayList<>();

        for (Video video : lista) {

            boolean curtiu = false;

            if (usuarioId > 0) {
                curtiu = curtirDAO.usuarioCurtiu(usuarioId, video.getId());
            }

            resultado.add(new Object[]{
                    video.getId(),
                    video.getTitulo(),
                    video.getDescricao(),
                    video.getCategoria(),
                    video.getClassificacaoIndicativa(),
                    curtiu ? "❤️" : ""
            });
        }

        return resultado;
    }
    
    public List<Object[]> buscarVideosParaTabela(
        String titulo,
        int usuarioId) {

        ArrayList<Video> lista =
                videoDAO.buscarVideosPorNome(titulo);

        List<Object[]> resultado = new ArrayList<>();

        for (Video video : lista) {

            boolean curtiu = false;

            if (usuarioId > 0) {

                curtiu = curtirDAO.usuarioCurtiu(
                        usuarioId,
                        video.getId()
                );
            }

            resultado.add(new Object[]{
                    video.getId(),
                    video.getTitulo(),
                    video.getDescricao(),
                    video.getCategoria(),
                    video.getClassificacaoIndicativa(),
                    curtiu ? "❤️" : ""
            });
        }

        return resultado;
    }
    
}
