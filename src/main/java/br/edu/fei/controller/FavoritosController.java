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
 * @author kamila
 * 
 * Controller responsável por gerenciar as regras relacionadas à lista de favoritos do usuário. 
 *
 */


public class FavoritosController {
    private final FavoritosDAO dao; //DAO presponsável pelos favoritos
    
    /**
     * Construtor do Controller
     * Inicializa o DAO de favoritos.
     */
    public FavoritosController() {this.dao = new FavoritosDAO();}

    //Cria a lista de favoritos do usuário caso ela ainda não exista.
    public void criarListaSeNaoExistir(int usuarioId) {
        if (!dao.existeLista(usuarioId)) {dao.criarLista(usuarioId);}}
    
    //Adiciona um vídeo à lista de favoritos do usuário.
    public void adicionarVideo(int usuarioId, int videoId) {
        criarListaSeNaoExistir(usuarioId); dao.adicionarVideo(usuarioId, videoId);}

    //Remove um vídeo específico da lista de favoritos do usuário.
    public void removerVideo(int usuarioId, int videoId) {
        dao.removerVideo(usuarioId, videoId);}
    
    //Exclui toda a lista de favoritos do usuário.
    public void excluirLista(int usuarioId) {dao.excluirLista(usuarioId);}

    //Retorna todos os vídeos que estão na lista de favoritos do usuário.
    public List<Video> listarFavoritos(int usuarioId) {
        return dao.listarFavoritos(usuarioId);}
}
