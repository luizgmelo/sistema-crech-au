package com.api.crechau.repositories;

import com.api.crechau.models.CaretakerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CaretakerRepository extends JpaRepository<CaretakerModel, UUID> {

}
