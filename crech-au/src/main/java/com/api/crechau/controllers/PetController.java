package com.api.crechau.controllers;

import com.api.crechau.dtos.PetRecordDto;
import com.api.crechau.services.PetService;
import com.api.crechau.utils.ApiGlobalResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/pet")
public class PetController {
    @Autowired
    PetService petService;

    @PostMapping
    public ResponseEntity<ApiGlobalResponseDto> savePet(@RequestBody @Valid PetRecordDto dto){
        var newPet = petService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiGlobalResponseDto(newPet));
    }

    @GetMapping
    public ResponseEntity<ApiGlobalResponseDto> getAllPet(@RequestParam(required = false) String search){
        var listPet = petService.findAll(search);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiGlobalResponseDto(listPet));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiGlobalResponseDto> getOnePet(@PathVariable(value = "id")UUID id){
        var pet = petService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiGlobalResponseDto(pet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiGlobalResponseDto> updatePet(@RequestBody @Valid PetRecordDto dto,
                                                          @PathVariable(value = "id") UUID id){
        var updatedPet = petService.update(dto, id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiGlobalResponseDto(updatedPet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePet(@PathVariable(value = "id") UUID id){
        petService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
