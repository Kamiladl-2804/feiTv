/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller;

import br.edu.fei.model.dao.CurtirDAO;

/**
 *
 * @author kamila
 * Controller responsável por gerenciar as regras relacionadas aos videos.
 */
public class VideoController {
    private final CurtirDAO dao; //DAO que cuida de curtidas
    
    //Construtor do controller. Usa o DAO de curtidas
    public VideoController() {

        dao = new CurtirDAO();
    }

    //Marca como curtido
    public void curtirVideo(int usuarioId, int videoId) {

        dao.curtirVideo(usuarioId, videoId);
    }

    //Remove curtida
    public void descurtirVideo(int usuarioId, int videoId) {

        dao.descurtirVideo(usuarioId, videoId);
    }
}
