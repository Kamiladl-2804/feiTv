/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller;

import br.edu.fei.model.dao.FavoritosDAO;
import br.edu.fei.model.Video;
import java.util.List;
/**
 *
 * @author kamil
 */
public class FavoritosController {
    private final FavoritosDAO dao;

    public FavoritosController() {
        this.dao = new FavoritosDAO();
    }

    public void criarListaSeNaoExistir(int usuarioId) {
        if (!dao.existeLista(usuarioId)) {
            dao.criarLista(usuarioId);
        }
    }

    public void adicionarVideo(int usuarioId, int videoId) {
        criarListaSeNaoExistir(usuarioId);
        dao.adicionarVideo(usuarioId, videoId);
    }

    public void removerVideo(int usuarioId, int videoId) {
        dao.removerVideo(usuarioId, videoId);
    }

    public void excluirLista(int usuarioId) {
        dao.excluirLista(usuarioId);
    }

    public List<Video> listarFavoritos(int usuarioId) {
        return dao.listarFavoritos(usuarioId);
    }
}
