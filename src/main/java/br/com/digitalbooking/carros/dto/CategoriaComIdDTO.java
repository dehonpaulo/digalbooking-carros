package br.com.digitalbooking.carros.dto;

import br.com.digitalbooking.carros.model.Categoria;

public class CategoriaComIdDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private String urlImagem;

    public CategoriaComIdDTO(Long id, String titulo, String descricao, String urlImagem) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.urlImagem = urlImagem;
    }

    public CategoriaComIdDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.titulo = categoria.getTitulo();
        this.descricao = categoria.getDescricao();
        this.urlImagem = categoria.getUrlImagem();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
