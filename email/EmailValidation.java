package com.bntaairport.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
    public boolean ValidateEmail(String email){
        // boolean result = email.equals("[a-z]+[\\.]*[a-z]*[0-9]*[\\@][a-z]*[\\.]com");

        // Establishes pattern to match
        Pattern pattern = Pattern.compile("[a-z]+[\\.]*[a-z]*[0-9]*[\\@][a-z]*[\\.]com");
        // Set matcher
        Matcher matcher = pattern.matcher(email);
        // Checks for match and return
        boolean result = matcher.matches();

        return result;
    }
}
