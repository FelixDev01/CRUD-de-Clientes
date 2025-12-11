package com.clientes.crud.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ClientRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String name;
    private String cpf;
    @PositiveOrZero(message = "A renda não deve ser negativa")
    @NotNull
    private Double income;
    @PastOrPresent(message = "A data não pode ser futura")
    @NotNull
    private LocalDate birthDate;
    @PositiveOrZero(message = "A quantidade de filhos não pode ser negativa")
    @NotNull
    private Integer children;

    public ClientRequestDTO() {
    }

    public ClientRequestDTO(String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
