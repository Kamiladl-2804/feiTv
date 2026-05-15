/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model;

/**
 *
 * @author kamil
 * Model de curtidas. Faz a ligação entre um usuário e um vídeo,
 * armazenando quais vídeos foram curtidos por cada usuário.
 */
public class Curtir {
    private int usuarioId; //ID do usuario que curtiu
    private int videoId; //ID do video curtido

    //Construtor vazio
    public Curtir() {
    }

    //Construtor completo pegando usuario e video 
    public Curtir(int usuarioId, int videoId) {
        this.usuarioId = usuarioId;
        this.videoId = videoId;
    }

    // Getters e Setters
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }
}
