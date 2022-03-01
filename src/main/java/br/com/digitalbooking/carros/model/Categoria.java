package br.com.digitalbooking.carros.model;

import br.com.digitalbooking.carros.dto.CategoriaComIdDTO;
import br.com.digitalbooking.carros.dto.CategoriaSemIdDTO;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String urlImagem;

    public Categoria() {
    }

    public Categoria(CategoriaSemIdDTO dtoSemId) {
        this.titulo = dtoSemId.getTitulo();
        this.descricao = dtoSemId.getDescricao();
        this.urlImagem = dtoSemId.getUrlImagem();
    }

    public Categoria(CategoriaComIdDTO dtoComId) {
        this.id = dtoComId.getId();
        this.titulo = dtoComId.getTitulo();
        this.descricao = dtoComId.getDescricao();
        this.urlImagem = dtoComId.getUrlImagem();
    }

    public Categoria(Long id, String titulo, String descricao, String urlImagem) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.urlImagem = urlImagem;
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
