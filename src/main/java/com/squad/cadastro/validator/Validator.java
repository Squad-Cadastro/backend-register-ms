package com.squad.cadastro.validator;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validator implements ValidatorInterface {
    @Override
    public boolean validarCPF(String documento) {
      if (documento.length() != 11) {
        return false;
      }

      int[] digitos = new int[11];
      for (int i = 0; i < 11; i++) {
        digitos[i] = documento.charAt(i) - '0';
      }

      int digitoVerificador1 = calcularDigitoVerificador(digitos, 10);
      int digitoVerificador2 = calcularDigitoVerificador(digitos, 11);

      return digitos[9] == digitoVerificador1 && digitos[10] == digitoVerificador2;
    }

    private int calcularDigitoVerificador(int[] digitos, int pesoInicial) {
      int soma = 0;
      for (int i = 0; i < 9; i++) {
        soma += digitos[i] * (pesoInicial - i);
      }

      int digitoVerificador = 11 - (soma % 11);
      return digitoVerificador >= 10 ? 0 : digitoVerificador;
    }

  static final String REGEX_EMAIL = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    @Override
    public boolean validarEmail(String email) {
        if (email == null || email.isBlank()) {
            return true;
        }
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }
    @Override
    public boolean validarData(LocalDate data) {
        var age = LocalDate.now().compareTo(data);
        return age < 18;
    }
}
