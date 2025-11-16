package com.usuarios.demo.controller;

import com.usuarios.demo.DTO.FilhoRequest;
import com.usuarios.demo.DTO.FilhoResponse;
import com.usuarios.demo.DTO.FilhoUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.usuarios.demo.service.FilhoService;

import java.util.List;

@RestController
@RequestMapping("/filhos")
public class FilhoController {
    @Autowired
    private FilhoService filhoService;

    @GetMapping
    public ResponseEntity<List<FilhoResponse>> listarFilhos(){
        List<FilhoResponse> filhoResponse = filhoService.listarFilhos();

        return ResponseEntity.ok(filhoResponse);
    }

    @PostMapping
    public ResponseEntity<FilhoResponse> salvarFilho(@RequestBody FilhoRequest filho){
        FilhoResponse filhoResponse = filhoService.salvarFilho(filho);
        return ResponseEntity.status(HttpStatus.CREATED).body(filhoResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilhoResponse> buscarFilhoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(filhoService.buscarFilhoPorId(id));
    }

    @DeleteMapping("/{id}")
    public void deletarFilho(@PathVariable Long id) {
        filhoService.deletarFilho(id);
    }

    @GetMapping("/pai/{id}")
    public ResponseEntity<List<FilhoResponse>> buscarFilhoPorPaiId(@PathVariable Long id){
        List<FilhoResponse> filhosResponse = filhoService.buscarFilhosPorPai(id);

        return ResponseEntity.ok(filhosResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilhoResponse> atualizarNomeFilho(@PathVariable Long id, @RequestBody FilhoUpdateRequest filhoUpdateRequest) {
        return ResponseEntity.ok(filhoService.atualizarNomeFilho(id, filhoUpdateRequest));
    }

}
