package com.mrc.appentrevista.util;

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
}
