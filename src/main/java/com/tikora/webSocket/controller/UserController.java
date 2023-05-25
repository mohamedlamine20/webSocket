package com.tikora.webSocket.controller;



import com.tikora.webSocket.dto.UserDTO;
import com.tikora.webSocket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController implements AbstractController<UserDTO,Long> {

  private final UserService   userService;
    @Override
    public ResponseEntity<UserDTO> save(UserDTO UserDTO) {
        return ResponseEntity.ok(userService.save(UserDTO));
    }

    @Override
    @CrossOrigin
    public ResponseEntity<UserDTO> update(UserDTO UserDTO) {
        return ResponseEntity.ok(userService.update(UserDTO));
    }

    @Override
    @CrossOrigin
    public ResponseEntity<UserDTO> getById(Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @Override
    @CrossOrigin
    public ResponseEntity<?> deleteByID(Long id) {
        userService.deleteByID(id);
        return ResponseEntity.ok("deleted");
    }

    @Override
    @CrossOrigin
    public ResponseEntity<List<UserDTO>> saveAll(List<UserDTO> UserDTOs) {
       return ResponseEntity.ok(userService.saveAll(UserDTOs));
    }

    @Override
    @CrossOrigin
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
}
