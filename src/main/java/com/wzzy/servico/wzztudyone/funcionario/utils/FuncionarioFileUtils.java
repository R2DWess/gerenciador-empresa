package com.wzzy.servico.wzztudyone.funcionario.utils;

public class FuncionarioFileUtils {

    public static String getFormato(String fileName) {
        if (fileName != null && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf('.') + 1).toUpperCase();
        }
        return "DESCONHECIDO";
    }
}
