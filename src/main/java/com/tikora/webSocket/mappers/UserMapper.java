package com.tikora.webSocket.mappers;

import com.tikora.webSocket.dto.UserDTO;
import com.tikora.webSocket.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends AbstractMapper<User, UserDTO> {
}
