package br.com.digitalbooking.carros.service;


import br.com.digitalbooking.carros.dto.CategoriaComIdDTO;
import br.com.digitalbooking.carros.dto.CategoriaSemIdDTO;
import br.com.digitalbooking.carros.exceptions.EntityNotFoundException;
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
        return categoriaRepository.findAll().stream().map(categoria -> {
            return new CategoriaSemIdDTO(categoria);
        }).collect(Collectors.toList());
    }

    public CategoriaSemIdDTO select(Long id) {
        return new CategoriaSemIdDTO(categoriaRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("Não há nenhum registro com o id " + id);
        }));
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

    public CategoriaSemIdDTO create(CategoriaSemIdDTO dtoSemId) {
        Categoria categoria = new Categoria(dtoSemId);
        return new CategoriaSemIdDTO(categoriaRepository.save(categoria));
    }

    // lidar com campos nulos ou vazios para que não sejam alterados
    public CategoriaComIdDTO update(CategoriaComIdDTO dtoComId) {
        return new CategoriaComIdDTO(categoriaRepository.save(new Categoria(dtoComId)));
    }
}