package com.squad.cadastro.validator;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validator implements ValidatorInterface {
    @Override
    public boolean validarCPF(String documento) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
            if (documento.equals("00000000000") ||
                    documento.equals("11111111111") ||
                    documento.equals("22222222222") || documento.equals("33333333333") ||
                    documento.equals("44444444444") || documento.equals("55555555555") ||
                    documento.equals("66666666666") || documento.equals("77777777777") ||
                    documento.equals("88888888888") || documento.equals("99999999999") ||
                    (documento.length() != 11)) {
                return false;
            }
        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int)(documento.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(documento.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            return (dig10 == documento.charAt(9)) && (dig11 == documento.charAt(10));
        } catch (InputMismatchException error) {
            return false;
        }


    }
    static final String REGEX_EMAIL = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    @Override
    public boolean validarEmail(String email){
        if(email == null || email.isBlank()){
            return true;
        }
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }

//    @Override
//    public boolean validarData(String data) {
//        DateFormat sdf = new SimpleDateFormat(data);
//        sdf.setLenient(false);
//        try {
//            sdf.parse(data);
//        } catch (ParseException e) {
//            return false;
//        }
//        return true;
//    }
    @Override
    public boolean validarData(String data) {
        try {
            SimpleDateFormat formatoDeData = new SimpleDateFormat("dd/MM/yyyy");
            formatoDeData.setLenient(false);
            formatoDeData.parse(data);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

}
