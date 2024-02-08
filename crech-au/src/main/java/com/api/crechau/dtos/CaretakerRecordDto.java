package com.api.crechau.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CaretakerRecordDto(@NotBlank(message = "Esse campo não pode ser enviado em branco!")
                                 @NotNull(message = "Campo obrigatório!")
                                 String name,
                                 @NotBlank(message = "Esse campo não pode ser enviado em branco!")
                                 @NotNull(message = "Campo obrigatório!")
                                 String gender,
                                 @NotBlank(message = "Esse campo não pode ser enviado em branco!")
                                 @NotNull(message = "Campo obrigatório!")
                                 String phoneNumber,
                                 String photoPath) {}
