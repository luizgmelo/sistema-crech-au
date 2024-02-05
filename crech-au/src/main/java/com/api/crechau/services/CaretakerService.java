package com.api.crechau.services;

import com.api.crechau.dtos.CaretakerRecordDto;
import com.api.crechau.exceptions.ResourceNotFoundException;
import com.api.crechau.models.CaretakerModel;
import com.api.crechau.repositories.CaretakerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class CaretakerService {
    @Autowired
    CaretakerRepository caretakerRepository;

    @Transactional
    public CaretakerModel save(CaretakerRecordDto dto){
        var newCaretaker = new CaretakerModel(dto);
        return caretakerRepository.save(newCaretaker);
    }

    public List<CaretakerModel> findAll(){
        return caretakerRepository.findAll();
    }

    public CaretakerModel findById(UUID id){
        Optional<CaretakerModel> caretakerModelOptional = caretakerRepository.findById(id);
        if (caretakerModelOptional.isEmpty()){
            throw new ResourceNotFoundException("Caretaker", "ID", id.toString());
        }
        return caretakerModelOptional.get();
    }

    public CaretakerModel update(UUID id, CaretakerRecordDto dto){
        Optional<CaretakerModel> caretakerModelOptional = caretakerRepository.findById(id);
        if (caretakerModelOptional.isEmpty()){
            throw new ResourceNotFoundException("Caretaker", "ID", id.toString());
        }
        BeanUtils.copyProperties(dto, caretakerModelOptional.get());
        return caretakerRepository.save(caretakerModelOptional.get());
    }

    @Transactional
    public void delete(UUID id){
        Optional<CaretakerModel> caretakerModelOptional = caretakerRepository.findById(id);
        if (caretakerModelOptional.isEmpty()){
            throw new ResourceNotFoundException("Caretaker", "ID", id.toString());
        }
        caretakerRepository.delete(caretakerModelOptional.get());
    }


}
