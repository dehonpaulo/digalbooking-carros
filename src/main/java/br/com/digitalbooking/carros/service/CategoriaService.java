package br.com.digitalbooking.carros.service;


import br.com.digitalbooking.carros.dto.CategoriaDTO;
import br.com.digitalbooking.carros.model.Categoria;
import br.com.digitalbooking.carros.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> selectAll() {
        return categoriaRepository.findAll();
    }

    public Categoria select(Long id) {
        return categoriaRepository.findById(id).get();
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria create(CategoriaDTO dto) {
        Categoria categoria = new Categoria(dto);
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
