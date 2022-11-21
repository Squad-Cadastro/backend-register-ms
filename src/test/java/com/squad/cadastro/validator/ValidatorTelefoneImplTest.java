package com.squad.cadastro.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTelefoneImplTest {

    ValidatorTelefone validatorTelefone;

    @BeforeEach
    void setUp() {
        this.validatorTelefone = new ValidatorTelefoneImpl();
    }

    @Test
    @DisplayName("Deve retornar True quando telefone estiver valido")
    void deveRetornarTrueCasoTelefoneValido() {
        Assertions.assertDoesNotThrow(()->{
            Assertions.assertTrue(this.validatorTelefone.validarTelefone("(11) 96359-2561"));
            Assertions.assertTrue(this.validatorTelefone.validarTelefone("11 963592561"));
            Assertions.assertTrue(this.validatorTelefone.validarTelefone("11963592561"));
        });
    }

    @Test
    @DisplayName("Deve retornar False quando telefone estiver invalido")
    void deveRetornarFalseCasoTelefoneInvalido() {
        Assertions.assertDoesNotThrow(()->{
            Assertions.assertFalse(this.validatorTelefone.validarTelefone("(00) 96359-2561"));
            Assertions.assertFalse(this.validatorTelefone.validarTelefone("11 6592561"));
            Assertions.assertFalse(this.validatorTelefone.validarTelefone("11635925"));
        });
    }

}