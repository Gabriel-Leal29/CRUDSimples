package com.usuarios.demo.controller;

import com.usuarios.demo.DTO.PaiRequest;
import com.usuarios.demo.DTO.PaiResponse;
import com.usuarios.demo.DTO.PaiUpdateRequest;
import com.usuarios.demo.mapper.PaiMapper;
import com.usuarios.demo.model.Pai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.usuarios.demo.service.PaiService;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaiController {

    @Autowired
    private PaiService paiService;

    @GetMapping
    public ResponseEntity<List<PaiResponse>> getPais() {
        List<PaiResponse> paisResponse = paiService.listarPais();

        return ResponseEntity.ok(paisResponse);
    }

    @PostMapping
    public ResponseEntity<PaiResponse> criarPai(@RequestBody PaiRequest paiRequest) {
        PaiResponse paiResponse = new PaiResponse();
        paiResponse = paiService.salvarPai(paiRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(paiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaiResponse> buscarPai(@PathVariable Long id) {
        return ResponseEntity.ok(paiService.buscarPaiPorId(id));
    }

    @DeleteMapping("/{id}")
    public void deletarPai(@PathVariable Long id){
        paiService.deletarPai(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaiResponse> alterarNomePai(@PathVariable Long id, @RequestBody PaiUpdateRequest paiUpdateRequest) {
        PaiResponse paiResponse = paiService.atualizarNomePai(id, paiUpdateRequest);

        return ResponseEntity.ok(paiResponse);
    }
}
