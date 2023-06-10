package com.jcm.store.products.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ProductRecordDto(@NotBlank  @NotEmpty String name,@NotNull BigDecimal value) {

}
