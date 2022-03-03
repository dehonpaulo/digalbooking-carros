package br.com.digitalbooking.carros.controller;

import br.com.digitalbooking.carros.dto.CategoriaComIdDTO;
import br.com.digitalbooking.carros.dto.CategoriaSemIdDTO;
import br.com.digitalbooking.carros.model.Categoria;
import br.com.digitalbooking.carros.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaSemIdDTO>> selectAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.selectAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaSemIdDTO> select(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.select(id));
    }

    // tratar caso onde todos os campos estão em branco (pelo menos o nome deve haver)
    @PostMapping
    public ResponseEntity<CategoriaSemIdDTO> create(@RequestBody CategoriaSemIdDTO dtoSemId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.create(dtoSemId));
    }

    // tratar caso onde não é informado o id e/ou todos os campos estão vazios
    @PutMapping
    public ResponseEntity<CategoriaComIdDTO> update(@RequestBody CategoriaComIdDTO dtoComId) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.update(dtoComId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
