package br.com.digitalbooking.carros.service;


import br.com.digitalbooking.carros.dto.CategoriaComIdDTO;
import br.com.digitalbooking.carros.dto.CategoriaSemIdDTO;
import br.com.digitalbooking.carros.exceptions.EntityNotFoundException;
import br.com.digitalbooking.carros.exceptions.UnreportedEssentialFieldException;
import br.com.digitalbooking.carros.model.Categoria;
import br.com.digitalbooking.carros.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaSemIdDTO> selectAll() {
        // transforma a lista de objetos do tipo Categoria em uma lista de DTOs e a retorna
        return categoriaRepository.findAll().stream().map(categoria -> {
            return new CategoriaSemIdDTO(categoria);
        }).collect(Collectors.toList());
    }

    public CategoriaSemIdDTO select(Long id) {
        // se houver um registro no DB com o id informado, ele será retornado como um dto
        // caso contrário, uma exceção é lançada
        return new CategoriaSemIdDTO(categoriaRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("Não há nenhum registro com o id " + id);
        }));
    }

    public CategoriaSemIdDTO create(CategoriaSemIdDTO dtoSemId) {
        // caso o título (atributo essencial) seja nulo, lança uma exceção
        if (dtoSemId.getTitulo() == null) throw new UnreportedEssentialFieldException("Titulo não informado");

        // instancia uma nova categoria, salva no DB e retorna como um dto
        Categoria categoria = new Categoria(dtoSemId);
        return new CategoriaSemIdDTO(categoriaRepository.save(categoria));
    }


    public CategoriaComIdDTO update(CategoriaComIdDTO dtoComId) {
        // caso o id informado seja nulo, lança uma exceção
        if(dtoComId.getId() == null) throw new UnreportedEssentialFieldException("Id não informado");

        // tenta pegar um registro do DB pelo id. Caso não haja, lança uma exceção
        Categoria categoria = categoriaRepository.findById(dtoComId.getId()).orElseThrow(() -> {
            return new EntityNotFoundException("Não há nenhum registro com o id " + dtoComId.getId());
        });

        // modifica apenas os campos não nulos passados na requisição
        if(dtoComId.getTitulo() != null) categoria.setTitulo(dtoComId.getTitulo());
        if(dtoComId.getDescricao() != null) categoria.setDescricao(dtoComId.getDescricao());
        if(dtoComId.getUrlImagem() != null) categoria.setUrlImagem(dtoComId.getUrlImagem());

        // altera o registro no DB e retorna sua nova forma como um dto
        return new CategoriaComIdDTO(categoriaRepository.save(categoria));
    }

    public void delete(Long id) {
        // verificando se há algum elemento no banco de dados com o id informado
        this.select(id);

        // excluindo o registro do banco de dados
        categoriaRepository.deleteById(id);
    }
}