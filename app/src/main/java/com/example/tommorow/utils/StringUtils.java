package com.example.tommorow.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 去除空格的工具类
 */

public class StringUtils {

    public static String c(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
