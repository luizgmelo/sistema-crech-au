package com.api.crechau.repositories;

import com.api.crechau.models.CaretakerModel;
import com.api.crechau.models.PetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PetRepository extends JpaRepository<PetModel, UUID> {
    List<PetModel> findAllByCaretaker(CaretakerModel caretakerModel);
    List<PetModel> findAllByNameContainingIgnoreCase(String search);

}
