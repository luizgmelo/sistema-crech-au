package com.api.crechau.controllers;

import com.api.crechau.dtos.CaretakerRecordDto;
import com.api.crechau.exceptions.ResourceNotFoundException;
import com.api.crechau.models.CaretakerModel;
import com.api.crechau.services.CaretakerService;
import com.api.crechau.utils.ApiGlobalResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/caretaker")
public class CaretakerController {
    @Autowired
    CaretakerService caretakerService;

    @PostMapping
    public ResponseEntity<ApiGlobalResponseDto> saveCaretaker(@RequestBody @Valid CaretakerRecordDto recordDto){
        var newCaretaker = caretakerService.save(recordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiGlobalResponseDto(newCaretaker));
    }

    @GetMapping
    public ResponseEntity<ApiGlobalResponseDto> getAllCaretaker(){
        var listCaretaker = caretakerService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ApiGlobalResponseDto(listCaretaker));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiGlobalResponseDto> getOneCaretaker(@PathVariable(value = "id") UUID id){
        CaretakerModel caretakerModel = caretakerService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiGlobalResponseDto(caretakerModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCaretaker(@RequestBody @Valid CaretakerRecordDto dto,
                                                  @PathVariable(value = "id") UUID id){
        var updatedCaretaker = caretakerService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiGlobalResponseDto(updatedCaretaker));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCaretaker(@PathVariable(value = "id") UUID id){
        caretakerService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
