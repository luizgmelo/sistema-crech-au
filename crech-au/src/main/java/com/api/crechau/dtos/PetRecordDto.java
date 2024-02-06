package com.api.crechau.dtos;

import com.api.crechau.models.CaretakerModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record PetRecordDto(@NotBlank @NotNull String name,
                           @NotBlank @NotNull String breed,
                           @NotNull double weight,
                           @NotNull int age,
                           @NotNull boolean isSociable,
                           @Length(min = 36, max = 36, message = "The sent value doesn't represents an ID")
                           String caretakerId) {
}
