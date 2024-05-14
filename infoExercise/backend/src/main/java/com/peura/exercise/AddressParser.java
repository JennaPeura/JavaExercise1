package com.peura.exercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressParser {
    public String extractNumber(String address) {
        String numberRegex = "\\b\\d{5}\\b";
        Pattern numberPattern = Pattern.compile(numberRegex);
        Matcher numberMatcher = numberPattern.matcher(address);
    
        return numberMatcher.find() ? numberMatcher.group() : "";
    }
    

    public String extractCity(String address) {
        String cityRegex = "\\b\\d{5}\\b\\s+(.+)$";
        Pattern cityPattern = Pattern.compile(cityRegex);
        Matcher cityMatcher = cityPattern.matcher(address);
    
        if (cityMatcher.find()) {
            return cityMatcher.group(1);
        } else {
            return "";
        }
    }
    

    public String extractActualAddress(String address) {
        String addressRegex = "(.*?),\\s*\\d{5}\\s*.*";
        Pattern addressPattern = Pattern.compile(addressRegex);
        Matcher addressMatcher = addressPattern.matcher(address);

        return addressMatcher.find() ? addressMatcher.group(1) : "";
    }
}
