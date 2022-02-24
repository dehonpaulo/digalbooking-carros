package br.com.digitalbooking.carros.dto;

import br.com.digitalbooking.carros.model.Categoria;

public class CategoriaDTO {
    private String titulo;
    private String descricao;
    private String urlImagem;

    public CategoriaDTO(String titulo, String descricao, String urlImagem) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.urlImagem = urlImagem;
    }

    public CategoriaDTO(Categoria categoria) {
        this.titulo = categoria.getTitulo();
        this.descricao = categoria.getDescricao();
        this.urlImagem = categoria.getUrlImagem();
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

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
