package com.tikora.webSocket.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AbstractController<DTO,ID>{
    @PostMapping()
    ResponseEntity<DTO> save(@RequestBody @Valid DTO dto);
    @PutMapping()
    ResponseEntity<DTO> update( @RequestBody DTO dto);
    @GetMapping("/{id}")
    ResponseEntity<DTO> getById(@PathVariable ID id);
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteByID(@PathVariable ID id);
    @PostMapping("/all")

    ResponseEntity<List<DTO>> saveAll(@RequestBody @Valid List<DTO> dtoList );
    @GetMapping
    ResponseEntity<List<DTO>> getAll();
}
