package com.mrc.appentrevista.util;

import android.content.Context;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringUtil {

    public static String marcaraMoeda(String moeda) {
        if (moeda == null) {
            return "";
        }
        moeda = moeda.replace(',', '.');
        return String.format("R$ %,.2f", Double.parseDouble(moeda));
    }

    public static String mascaraDataBr(String data) {
        String ano = data.substring(0, 4);
        String mes = data.substring(5, 7);
        String dia = data.substring(8);
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
        return new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime());
    }

    public static Boolean validacaoSenhaSegura(Context context, String pass) throws Exception {
        String[] senha = new String[pass.length()];
        for (int i = 0; i < senha.length; i++) {
            senha[i] = String.valueOf(pass.charAt(i));
        }

        if (!verificarMinusculo(senha)) {
            throw new Exception("Precisa de letra MINÚSCULA");
        } else if (!verificarMaiusculo(senha)) {
            throw new Exception("Precisa de letra MAIUSCULA");
        } else if (!verificarNumeros(senha)) {
            throw new Exception("Precisa de um NÚMERO");
        } else if (!verificarSimbolo(senha)) {
            throw new Exception("Precisa de um SIMBOLO");
        }

        return true;
    }


    private static boolean verificarMinusculo(String[] senha) {
        String[] valorMinusculo = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",};
        for (int i = 0; i < valorMinusculo.length; i++) {
            for (int j = 0; j < senha.length; j++) {
                System.out.println("Senha: " + senha[j] + "// Minusculo: " + valorMinusculo[i]);
                if (senha[j].equals(valorMinusculo[i])) {
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean verificarMaiusculo(String[] senha) {
        String[] valorMaiusculo = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",};
        for (int i = 0; i < valorMaiusculo.length; i++) {
            for (int j = 0; j < senha.length; j++) {
                System.out.println("Senha: " + senha[j] + "// Maiusculo: " + valorMaiusculo[i]);
                if (senha[j].equals(valorMaiusculo[i])) {
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean verificarNumeros(String[] senha) {
        String[] valorNumeros = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        for (int i = 0; i < valorNumeros.length; i++) {
            for (int j = 0; j < senha.length; j++) {
                System.out.println("Senha: " + senha[j] + "// Numeros: " + valorNumeros[i]);
                if (senha[j].equals(valorNumeros[i])) {
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean verificarSimbolo(String[] senha) {
        String[] valorNumeros = {"!", "@", "#", "$", "%", "6", "¨&", "*", "(", ")", "-", "=", "+"};
        for (int i = 0; i < valorNumeros.length; i++) {
            for (int j = 0; j < senha.length; j++) {
                System.out.println("Senha: " + senha[j] + "// Simbolo: " + valorNumeros[i]);
                if (senha[j].equals(valorNumeros[i])) {
                    return true;
                }
            }

        }
        return false;
    }
}
