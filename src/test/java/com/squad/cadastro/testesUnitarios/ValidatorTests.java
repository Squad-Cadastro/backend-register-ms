package com.squad.cadastro.testesUnitarios;

import com.squad.cadastro.validator.Validator;
import com.squad.cadastro.validator.ValidatorInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


public class ValidatorTests {
  @Mock
  private ValidatorInterface validatorInterface;

  @InjectMocks
  private Validator validator;

  @BeforeEach
  public void setUp(){
    MockitoAnnotations.openMocks(this);
  }

  //Testes unitários para Cpf
  @Test
  @DisplayName("Should returns true when CPF is Valid")
  public void TesteValidarCPF_QuandoCPFValidoRetornaTrue(){
    String cpf = "12345678909";
    when(validatorInterface.validarCPF(cpf)).thenReturn(true);

    boolean result = validator.validarCPF(cpf);
    assertTrue(result);
  }

  @Test
  @DisplayName("Should returns false when CPF isn't Valid")
  public void testeValidarCPFQuandoCPFInvalidoRetornaFalse() {
    String cpf = "12345678900";
    when(validatorInterface.validarCPF(cpf)).thenReturn(false);

    boolean result = validator.validarCPF(cpf);
    assertFalse(result);
  }

  //Testes Unitários para Email
  @Test
  @DisplayName("Should returns true when E-Mail is Null")
  public void TesteValidarEmailQuandoEmailForNullRetornaTrue() {
    String email = null;
    boolean result = validator.validarEmail(email);
    assertTrue(result);
  }

  @Test
  @DisplayName("should return true when email is blank")
  public void testeValidarEmailQuandoEmailForVazioRetornaTrue() {
    String email = " ";
    boolean result = validator.validarEmail(email);
    assertTrue(result);
  }

  @Test
  @DisplayName("should return false when email is Valid")
  public void testeValidarEmailQuandoEmailForValidoRetornaFalse() {
    String email = "teste@exemplo.com";
    boolean result = validator.validarEmail(email);
    assertFalse(result);
  }

  @Test
  @DisplayName("should return true when email is inValid")
  public void testeValidarEmailQuandoEmailForInvaalidoRetornaTrue() {
    String email = "teste@exemplo-invalido";
    boolean result = validator.validarEmail(email);
    assertTrue(result);
  }
}