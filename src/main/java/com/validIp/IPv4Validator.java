package com.validIp;

/**
 * Сравнивае вводимый IP адрес с паттерном
 *
 * @author      Eugen Landarenko
 * @version     1.0
 * @link        https://github.com/evgen-jkay/ValidationIp
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPv4Validator {

    private static final String IPV4_PATTERN =
            "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";

    private static final Pattern pattern = Pattern.compile(IPV4_PATTERN);

    /**
     * @param inputIp   Input IP address
     * @return          true or false
     */
    public static boolean isValid(final String inputIp) {
        Matcher matcher = pattern.matcher(inputIp);
        return matcher.matches();
    }

}
