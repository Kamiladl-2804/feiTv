/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model;

/**
 *
 * @author kamil
 * Model para favoritos. representa a lista de favoritos de um usuario
 */
public class Favoritos {
   private int id; //ID da lista de favoritos
    private int usuarioId; //ID do usuario

    //Construtor vazio
    public Favoritos() {
    }

    //Construtor completo com os IDs da lista e do usuario que tem a lista
    public Favoritos(int id, int usuarioId) {
        this.id = id;
        this.usuarioId = usuarioId;
    }


    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    } 
}
