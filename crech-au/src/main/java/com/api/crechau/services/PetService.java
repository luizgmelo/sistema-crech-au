package com.api.crechau.services;

import com.api.crechau.dtos.PetRecordDto;
import com.api.crechau.exceptions.ResourceNotFoundException;
import com.api.crechau.models.PetModel;
import com.api.crechau.repositories.CaretakerRepository;
import com.api.crechau.repositories.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;
    @Autowired
    CaretakerRepository caretakerRepository;

    @Transactional
    public PetModel save(PetRecordDto dto){
        var caretaker = caretakerRepository.findById(UUID.fromString(dto.caretakerId()));
        if (caretaker.isEmpty()){
            throw new ResourceNotFoundException("Caretaker", "ID", dto.caretakerId());
        }

        var petModel = new PetModel(dto, caretaker.get());
        return petRepository.save(petModel);
    }

    public List<PetModel> findAll(String search) {
        if (search != null){
            return petRepository.findAllByNameContainingIgnoreCase(search);
        }
        return petRepository.findAll();
    }

    public PetModel findById(UUID id) {
        var petModelOptional = petRepository.findById(id);
        if (petModelOptional.isEmpty()){
            throw new ResourceNotFoundException("Pet", "ID", id.toString());
        }
        return petModelOptional.get();
    }

    public PetModel update(PetRecordDto dto, UUID id){
        var petModelOptional = petRepository.findById(id);
        if (petModelOptional.isEmpty()){
            throw new ResourceNotFoundException("Pet", "ID", id.toString());
        }

        var caretakerModelOptional = caretakerRepository.findById(UUID.fromString(dto.caretakerId()));
        if (caretakerModelOptional.isEmpty()){
            throw new ResourceNotFoundException("Caretaker", "ID", dto.caretakerId());
        }

        BeanUtils.copyProperties(dto, petModelOptional.get());
        petModelOptional.get().setCaretaker(caretakerModelOptional.get());
        return petRepository.save(petModelOptional.get());
    }

    public void delete(UUID id){
        var petModelOptional = petRepository.findById(id);
        if (petModelOptional.isEmpty()){
            throw new ResourceNotFoundException("Pet", "ID", id.toString());
        }
        petRepository.deleteById(id);
    }


}
