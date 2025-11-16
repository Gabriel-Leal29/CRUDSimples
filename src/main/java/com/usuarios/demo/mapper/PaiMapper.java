package com.usuarios.demo.mapper;

import com.usuarios.demo.DTO.PaiRequest;
import com.usuarios.demo.DTO.PaiResponse;
import com.usuarios.demo.model.Pai;

public class PaiMapper {

    public static Pai toEntity(PaiRequest paiRequest){
        Pai pai = new Pai();
        pai.setNome(paiRequest.getNome());
        pai.setIdade(paiRequest.getIdade());
        return pai;
    }

    public static PaiResponse toResponse(Pai pai){
        PaiResponse paiResponse = new PaiResponse();
        paiResponse.setId(pai.getId());
        paiResponse.setNome(pai.getNome());
        paiResponse.setIdade(pai.getIdade());

        if (pai.getFilhos() != null) {
            paiResponse.setNomesFilhos(
                    pai.getFilhos()
                            .stream()
                            .map(f -> f.getNome())
                            .toList()
            );
        }

        return paiResponse;
    }
}
