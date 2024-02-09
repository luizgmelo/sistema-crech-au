package com.api.crechau.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record PetRecordDto(@NotBlank(message = "Esse campo não pode ser enviado em branco!")
                           @NotNull(message = "Campo obrigatório!")
                           String name,
                           @NotBlank(message = "Esse campo não pode ser enviado em branco!")
                           @NotNull(message = "Campo obrigatório!")
                           String breed,
                           @NotNull(message = "Campo obrigatório!")
                           Double weight,
                           @NotNull (message = "Campo obrigatório!")
                           Integer age,
                           @NotNull (message = "Campo obrigatório!")
                           Boolean isSociable,
                           @Length(min = 36, max = 36, message = "O valor não representa um ID válido")
                           String caretakerId) {
}
