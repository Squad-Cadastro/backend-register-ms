package com.squad.cadastro.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class ValidatorTest {

    ValidatorInterface validatorInterface;

    @BeforeEach
    void setUp() {
        this.validatorInterface = new Validator();
    }

    @Test
    @DisplayName("Validar Data deve Retornar true em caso cliente ser maior de 18 anos")
    void validarDataDeveRetornarTrueQuandoMaiorDe18() {
        var request_date = LocalDate.parse("1994-04-22");
        Assertions.assertDoesNotThrow(()->{
            final var result = validatorInterface.validarData(request_date);
            Assertions.assertFalse(result);
        });
    }

    @Test
    @DisplayName("Validar Data deve Retornar false em caso cliente ser menor de 18 anos")
    void validarDataDeveRetornarFalseQuandoMenorDe18() {
        var request_date = LocalDate.parse("2010-04-22");
        Assertions.assertDoesNotThrow(()->{
            final var result = validatorInterface.validarData(request_date);
            Assertions.assertTrue(result);
        });
    }
}