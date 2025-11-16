package com.usuarios.demo.mapper;

import com.usuarios.demo.DTO.FilhoRequest;
import com.usuarios.demo.DTO.FilhoResponse;
import com.usuarios.demo.model.Filho;
import com.usuarios.demo.model.Pai;

public class FilhoMapper {

    public static Filho toEntity(FilhoRequest filhoRequest){
        Filho filho = new Filho();
        filho.setNome(filhoRequest.getNome());
        filho.setIdade(filhoRequest.getIdade());
        Pai pai = new Pai();
        pai.setIdPai(filhoRequest.getIdPai());
        filho.setPai(pai);

        return filho;
    }

    public static FilhoResponse toResponse(Filho filho){
        FilhoResponse filhoResponse = new FilhoResponse();
        filhoResponse.setNome(filho.getNome());
        filhoResponse.setId(filho.getId());
        filhoResponse.setIdade(filho.getIdade());
        filhoResponse.setNomePai(filho.getPai().getNome());
        return filhoResponse;
    }
}
