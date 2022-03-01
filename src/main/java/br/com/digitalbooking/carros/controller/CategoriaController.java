package br.com.digitalbooking.carros.controller;

import br.com.digitalbooking.carros.dto.CategoriaComIdDTO;
import br.com.digitalbooking.carros.dto.CategoriaSemIdDTO;
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
    public List<CategoriaSemIdDTO> selectAll() {
        return categoriaService.selectAll();
    }

    // tratar caso onde não há um elemento com o id informado
    @GetMapping("/{id}")
    public CategoriaSemIdDTO select(@PathVariable Long id) {
        return categoriaService.select(id);
    }

    // tratar caso onde todos os campos estão em branco (pelo menos o nome deve haver)
    @PostMapping
    public CategoriaSemIdDTO create(@RequestBody CategoriaSemIdDTO dtoSemId) {
        return categoriaService.create(dtoSemId);
    }

    // tratar caso onde não é informado o id e/ou todos os campos estão vazios
    @PutMapping
    public CategoriaComIdDTO update(@RequestBody CategoriaComIdDTO dtoComId) {
        return categoriaService.update(dtoComId);
    }

    // tratar caso onde não há uma categoria com o id informado
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoriaService.delete(id);
    }
}
