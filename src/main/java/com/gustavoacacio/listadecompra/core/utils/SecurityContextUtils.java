package com.gustavoacacio.listadecompra.core.utils;

import com.gustavoacacio.listadecompra.exception.ExtrairUsuarioLogadoException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecurityContextUtils {

    private SecurityContextUtils() {
    }

    public static String getUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return extractUsername(auth.getName());
    }

    private static String extractUsername(String input) {
        Pattern pattern = Pattern.compile("username=([^,\\]]+)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        throw new ExtrairUsuarioLogadoException();
    }
}
