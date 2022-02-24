package br.com.digitalbooking.carros.controller;

import br.com.digitalbooking.carros.dto.CategoriaDTO;
import br.com.digitalbooking.carros.model.Categoria;
import br.com.digitalbooking.carros.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> selectAll() {
        return categoriaService.selectAll();
    }

    @GetMapping("/{id}")
    public CategoriaDTO select(@PathVariable Long id) {
        return new CategoriaDTO(categoriaService.select(id));
    }

    @PostMapping
    public CategoriaDTO create(@RequestBody CategoriaDTO categoria) {
        return new CategoriaDTO(categoriaService.create(categoria));
    }

    @PutMapping
    public Categoria update(@RequestBody Categoria categoria) {
        return categoriaService.update(categoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoriaService.delete(id);
    }
}
