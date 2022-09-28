package com.squad.cadastro.validator;

public interface ValidatorInterface {
    boolean validarCPF(String documento);

    boolean validarEmail(String email);

    boolean validarData(String data);

}
