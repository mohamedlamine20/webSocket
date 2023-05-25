package com.tikora.webSocket.service;

import com.tikora.webSocket.dto.UserDTO;
import com.tikora.webSocket.mappers.UserMapper;

import com.tikora.webSocket.models.User;
import com.tikora.webSocket.models.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements AbstractService<User, UserDTO, Long> {

    private final UserRepository userModelRepository;
    private final UserMapper userMapper;
    @Override
    public UserDTO save(UserDTO userDTO) {
        return userMapper.to(userModelRepository.save(userMapper.from(userDTO)));
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return userMapper.to(userModelRepository.save(userMapper.from(userDTO)));
    }

    @Override
    public UserDTO getById(Long aLong) {
    return userMapper.to(userModelRepository.findById(aLong).orElseThrow(() -> new NotFoundException("user not found")));
    }

    @Override
    public void deleteByID(Long aLong) {

    }

    @Override
    public List<UserDTO> saveAll(List<UserDTO> userDTOS) {
        return userMapper.to(userModelRepository.saveAll(userMapper.from(userDTOS)));
    }

    @Override
    public List<UserDTO> getAll() {
        return userMapper.to(userModelRepository.findAll());
    }


    public Optional<User>  getByEmail(String email){
        return userModelRepository.findByEmail(email);
    }

}
