package com.api.crechau.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CaretakerRecordDto(@NotBlank @NotNull String name,
                                 @NotBlank @NotNull String gender,
                                 @NotBlank @NotNull String phoneNumber) {}
