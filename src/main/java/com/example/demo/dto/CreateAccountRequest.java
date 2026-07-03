package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateAccountRequest {

    @NotBlank(message = "Account owner name is required")
    private String accountOwnerName;
}
