/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller;

import javax.swing.JFrame;
import br.edu.fei.model.dao.FavoritosDAO;
import br.edu.fei.model.Video;
import br.edu.fei.model.dao.CurtirDAO;
import br.edu.fei.view.FavoritosJFrame;
import br.edu.fei.view.LoginJFrame;
import br.edu.fei.view.PrincipalJFrame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author kamila
 * 
 * Controller responsável por gerenciar as regras relacionadas à lista de favoritos do usuário. 
 *
 */




public class FavoritosController {
    private final FavoritosDAO dao; //DAO presponsável pelos favoritos
    private final JFrame view;
    /**
     * Construtor do Controller
     * Inicializa o DAO de favoritos.
     */
    public FavoritosController(JFrame view) {
        this.view = view;
        this.dao = new FavoritosDAO();
    }

    //Cria a lista de favoritos do usuário caso ela ainda não exista.
    public void criarListaSeNaoExistir(int usuarioId) {
        if (!dao.existeLista(usuarioId)) {dao.criarLista(usuarioId);}}
    
    //Adiciona um vídeo à lista de favoritos do usuário.
    public void adicionarVideo(int usuarioId, int videoId) {
        criarListaSeNaoExistir(usuarioId); dao.adicionarVideo(usuarioId, videoId);}
    
    public void IrParaFavoritos(int usuarioId) {

        if (usuarioId <= 0) {
            JOptionPane.showMessageDialog(view,
                    "Usuário inválido. Faça login novamente.");
            return;
        }

        if (!dao.existeLista(usuarioId)) {
            JOptionPane.showMessageDialog(view,
                    "Você ainda não possui lista de favoritos.\nAdicione um vídeo para criar sua lista.");
            return;
        }

        FavoritosJFrame tela = new FavoritosJFrame();
        tela.setUsuarioId(usuarioId);
        tela.setVisible(true);

        view.dispose();
    }

    public void adicionarFavorito(int usuarioId, int videoId) {

        if (usuarioId <= 0) {
            JOptionPane.showMessageDialog(view, "Usuário inválido!");
            return;
        }

        criarListaSeNaoExistir(usuarioId);

        List<Video> favoritos = dao.listarFavoritos(usuarioId);

        for (Video video : favoritos) {
            if (video.getId() == videoId) {
                JOptionPane.showMessageDialog(view, "Esse vídeo já está nos favoritos!");
                return;
            }
        }

        dao.adicionarVideo(usuarioId, videoId);

        JOptionPane.showMessageDialog(view, "Adicionado aos favoritos!");
    }
    
    //Remove um vídeo específico da lista de favoritos do usuário.
    public void removerVideo(int usuarioId, int videoId) {
        dao.removerVideo(usuarioId, videoId);
        JOptionPane.showMessageDialog(view, "Removido dos favoritos!");}
    
    //Exclui toda a lista de favoritos do usuário.
    public void excluirLista(int usuarioId) {dao.excluirLista(usuarioId);}

    //Retorna todos os vídeos que estão na lista de favoritos do usuário.
    public List<Video> listarFavoritos(int usuarioId) {
        return dao.listarFavoritos(usuarioId);}
    
    public boolean usuarioCurtiu(int usuarioId, int videoId) {
        return new CurtirDAO().usuarioCurtiu(usuarioId, videoId);
    }
    
    public void irParaPrincipal(int usuarioId) {

        PrincipalJFrame tela = new PrincipalJFrame();
        tela.setUsuarioId(usuarioId);
        tela.setVisible(true);

        view.dispose();
    }
    
    public void irParaLogin() {
        LoginJFrame login = new LoginJFrame();
        login.setController(new LoginController());
        login.setVisible(true);
        view.dispose();
    }
    public void adicionarFavorito(PrincipalJFrame tela) {

        int linha = tela.getTblVideos().getSelectedRow();

        if (linha == -1) {

            tela.mostrarMensagem("Selecione um vídeo!");
            return;
        }

        int videoId =
                (int) tela.getTblVideos().getValueAt(linha, 0);

        int usuarioId = tela.getUsuarioId();

        if (usuarioId <= 0) {

            tela.mostrarMensagem("Usuário inválido!");
            return;
        }

        criarListaSeNaoExistir(usuarioId);

        List<Video> favoritos =
                dao.listarFavoritos(usuarioId);

        for (Video video : favoritos) {

            if (video.getId() == videoId) {

                tela.mostrarMensagem(
                        "Esse vídeo já está nos favoritos!"
                );

                return;
            }
        }

        dao.adicionarVideo(usuarioId, videoId);

        tela.mostrarMensagem("Adicionado aos favoritos!");

        tela.listarVideosTela();
    }
    
    public List<Object[]> listarFavoritosParaTabela(int usuarioId) {

        List<Video> lista = dao.listarFavoritos(usuarioId);

        List<Object[]> resultado = new ArrayList<>();

        for (Video video : lista) {

            boolean curtiu =
                    usuarioCurtiu(usuarioId, video.getId());

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
    
    public void removerFavorito(FavoritosJFrame tela) {

        int linha = tela.getTabela().getSelectedRow();

        if (linha == -1) {

            tela.mostrarMensagem("Selecione um vídeo!");
            return;
        }

        int videoId =
                (int) tela.getTabela().getValueAt(linha, 0);

        int usuarioId = tela.getUsuarioId();

        dao.removerVideo(usuarioId, videoId);

        tela.mostrarMensagem("Removido dos favoritos!");

        tela.listarFavoritos();
    }
    
    public void excluirLista(FavoritosJFrame tela) {

        int confirm = JOptionPane.showConfirmDialog(
                tela,
                "Deseja realmente excluir toda a lista?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {

            dao.excluirLista(tela.getUsuarioId());

            tela.mostrarMensagem("Lista excluída!");

            tela.listarFavoritos();
        }
    }
}
