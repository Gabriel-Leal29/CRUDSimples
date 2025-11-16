package com.usuarios.demo.service;

import com.usuarios.demo.DTO.PaiRequest;
import com.usuarios.demo.DTO.PaiResponse;
import com.usuarios.demo.DTO.PaiUpdateRequest;
import com.usuarios.demo.mapper.PaiMapper;
import com.usuarios.demo.model.Filho;
import com.usuarios.demo.model.Pai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usuarios.demo.repository.PaiRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class PaiService {

    @Autowired
    private PaiRepository paiRepository;

    public PaiService() {}

    public PaiResponse salvarPai(PaiRequest paiRequest) {
        Pai pai = paiRepository.save(PaiMapper.toEntity(paiRequest));
        return PaiMapper.toResponse(pai);
    }
    public void deletarPai(Long paiId) {
        paiRepository.deleteById(paiId);
    }
    public List<PaiResponse> listarPais() {
        return paiRepository.findAll()
                .stream()
                .map(PaiMapper::toResponse)
                .toList();
    }
    public PaiResponse buscarPaiPorId(Long id) {
        Pai pai = paiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pai não encontrado!"));

        return PaiMapper.toResponse(pai);
    }

    public PaiResponse atualizarNomePai(Long id, PaiUpdateRequest paiUpdateRequest) {
        Pai pai = paiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pai não encontrado!"));

        pai.setNome(paiUpdateRequest.getNome());
        return PaiMapper.toResponse(paiRepository.save(pai));
    }
}
