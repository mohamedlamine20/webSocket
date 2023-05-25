package com.tikora.webSocket.mappers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface AbstractMapper<ENTITY,DTO>{

    ENTITY from(DTO dto);

    DTO to(ENTITY entity);


    default List<ENTITY> from(Collection<DTO> collection){
        return collection.stream().map(this::from).collect(Collectors.toList());
    }

    default List<DTO> to(Collection<ENTITY> collection){
        return collection.stream().map(this::to).collect(Collectors.toList());
    }
}
