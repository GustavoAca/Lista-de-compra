package com.gustavoacacio.listadecompra.core.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecurityContextUtils {

    private SecurityContextUtils() {
    }

    public static String getUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return Objects.nonNull(auth) ? extractUsername(auth.getName()) : null;
    }

    public static String extractUsername(String input) {
        String regex = "username=(.*?),";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return null;
    }
}
