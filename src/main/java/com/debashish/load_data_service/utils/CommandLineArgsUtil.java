package com.debashish.load_data_service.utils;

public class CommandLineArgsUtil {

    public static String getArgValue(String[] args, String key) {
        String prefix = key + "=";
        for (String arg : args) {
            if (arg.startsWith(prefix)) {
                return arg.substring(prefix.length());
            }
        }
        throw new IllegalArgumentException("Missing required argument: " + prefix + "<value>");
    }
}