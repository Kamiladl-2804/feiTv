/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model;

/**
 *
 * @author kamil
 * modelo do video no programa, todos os videos são da marvel e voltados para uma 
 * versão com apenas alguns dados dos filmes
 */
public class Video {

    private int id;//ID do video
    private String titulo; //nome do video
    private String descricao; //destrição do video
    private String categoria; //categoria do video
    private String classificacaoIndicativa;//classificação de idadde do video

    //construtor do video vazio
    public Video() {
    }

    //construtor completo com o nome, descrição, categoria e classificação de idade
    public Video(String titulo, String descricao, String categoria, String classificacaoIndicativa) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.classificacaoIndicativa = classificacaoIndicativa;
    }
    
    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }
}