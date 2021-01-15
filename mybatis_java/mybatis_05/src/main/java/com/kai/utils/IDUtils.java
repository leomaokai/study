package com.kai.utils;

import java.util.UUID;

public class IDUtils {
    public static String getID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
