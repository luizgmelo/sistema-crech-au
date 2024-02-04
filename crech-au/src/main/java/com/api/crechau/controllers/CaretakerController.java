package com.api.crechau.controllers;

import com.api.crechau.dtos.CaretakerRecordDto;
import com.api.crechau.models.CaretakerModel;
import com.api.crechau.services.CaretakerService;
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
    public ResponseEntity<Object> saveCaretaker(@RequestBody @Valid CaretakerRecordDto recordDto){
        var caretakerModel = new CaretakerModel(recordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(caretakerService.save(caretakerModel));
    }

    @GetMapping
    public ResponseEntity<List<CaretakerModel>> getAllCaretaker(){
        return ResponseEntity.status(HttpStatus.OK).body(caretakerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCaretaker(@PathVariable(value = "id") UUID id){
        Optional<CaretakerModel> caretakerModelOptional = caretakerService.findById(id);
        if (caretakerModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(caretakerModelOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Caretaker not found.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCaretaker(@RequestBody @Valid CaretakerRecordDto recordDto,
                                                  @PathVariable(value = "id") UUID id){
        Optional<CaretakerModel> caretakerModelOptional = caretakerService.findById(id);
        if (caretakerModelOptional.isPresent()){
            var caretakerModel = caretakerModelOptional.get();
            BeanUtils.copyProperties(recordDto, caretakerModel);
            return ResponseEntity.status(HttpStatus.OK).body(caretakerService.save(caretakerModel));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Caretaker not found.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCaretaker(@PathVariable(value = "id") UUID id){
        Optional<CaretakerModel> caretakerModelOptional = caretakerService.findById(id);
        if (caretakerModelOptional.isPresent()){
            caretakerService.delete(caretakerModelOptional.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Caretaker deletado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Caretaker not found.");
    }
}
