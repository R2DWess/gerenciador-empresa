package com.wzzy.servico.wzztudyone.empresa.utils;

public class FileUtils {

    public static String getFormato(String fileName) {
        if (fileName != null && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf('.') + 1).toUpperCase();
        }
        return "DESCONHECIDO";
    }
}
