package com.api.crechau.services;

import com.api.crechau.models.CaretakerModel;
import com.api.crechau.repositories.CaretakerRepository;
import jakarta.transaction.Transactional;
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
    public CaretakerModel save(CaretakerModel caretakerModel){
        return caretakerRepository.save(caretakerModel);
    }

    public List<CaretakerModel> findAll(){
        return caretakerRepository.findAll();
    }

    public Optional<CaretakerModel> findById(UUID id){
        return caretakerRepository.findById(id);
    }

    public void delete(CaretakerModel caretakerModel){
        caretakerRepository.delete(caretakerModel);
    }


}
