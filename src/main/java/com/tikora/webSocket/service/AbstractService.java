package com.tikora.webSocket.service;

import java.util.List;

public interface AbstractService <ENTITY,DTO,ID>{

    DTO save(DTO dto);
    DTO update(DTO dto);
    DTO getById(ID id);
    void deleteByID(ID id);

    List<DTO> saveAll(List<DTO> dtoList );
    List<DTO> getAll();
}
