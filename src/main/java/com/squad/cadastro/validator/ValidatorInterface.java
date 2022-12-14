package com.squad.cadastro.validator;

import java.time.LocalDate;

public interface ValidatorInterface {
    boolean validarCPF(String documento);

    boolean validarEmail(String email);

    boolean validarIdade(LocalDate data);

}
