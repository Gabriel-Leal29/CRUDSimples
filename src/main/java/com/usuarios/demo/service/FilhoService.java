package com.usuarios.demo.service;

import com.usuarios.demo.DTO.FilhoRequest;
import com.usuarios.demo.DTO.FilhoResponse;
import com.usuarios.demo.DTO.FilhoUpdateRequest;
import com.usuarios.demo.DTO.PaiResponse;
import com.usuarios.demo.mapper.FilhoMapper;
import com.usuarios.demo.model.Filho;
import com.usuarios.demo.model.Pai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usuarios.demo.repository.FilhoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FilhoService {
    @Autowired
    private FilhoRepository filhoRepository;
    @Autowired
    private PaiService paiService;

    public FilhoService() {}
    public FilhoResponse salvarFilho(FilhoRequest filhoRequest) {
        Filho filho = FilhoMapper.toEntity(filhoRequest);
        PaiResponse paiResponse = paiService.buscarPaiPorId(filhoRequest.getIdPai());

        Pai pai = new Pai();
        pai.setIdPai(paiResponse.getId());
        pai.setNome(paiResponse.getNome());
        pai.setIdade(paiResponse.getIdade());

        filho.setPai(pai);

        return FilhoMapper.toResponse(filhoRepository.save(filho));
    }
    public void deletarFilho(Long id) {
        filhoRepository.deleteById(id);
    }
    public FilhoResponse buscarFilhoPorId(Long id) {
        Filho filho = filhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filho não encontrado!"));

        return FilhoMapper.toResponse(filho);
    }
    public List<FilhoResponse> listarFilhos(){
        return filhoRepository.findAll()
                .stream()
                .map(FilhoMapper::toResponse)
                .toList();
    }
    public List<FilhoResponse> buscarFilhosPorPai(Long idPai) {
        return filhoRepository.buscarFilhosPorPai(idPai)
                .stream()
                .map(FilhoMapper::toResponse)
                .toList();
    }

    public FilhoResponse atualizarNomeFilho(Long id, FilhoUpdateRequest filhoUpdateRequest) {
        Filho filho = filhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filho não encontrado!"));

        filho.setNome(filhoUpdateRequest.getNome());
        return FilhoMapper.toResponse(filhoRepository.save(filho));
    }
}
