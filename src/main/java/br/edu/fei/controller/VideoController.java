/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller;

import br.edu.fei.model.dao.CurtirDAO;

/**
 *
 * @author kamil
 */
public class VideoController {
    private CurtirDAO dao;

    public VideoController() {

        dao = new CurtirDAO();
    }

    public void curtirVideo(int usuarioId, int videoId) {

        dao.curtirVideo(usuarioId, videoId);
    }

    public void descurtirVideo(int usuarioId, int videoId) {

        dao.descurtirVideo(usuarioId, videoId);
    }
}
