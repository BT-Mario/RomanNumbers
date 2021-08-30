package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class RomanApplicationTests {

    @Test
    public void testConvertUnits() {
        assertEquals("I", convertToRomansString(1));
        assertEquals("II", convertToRomansString(2));
        assertEquals("III", convertToRomansString(3));
        assertEquals("IV", convertToRomansString(4));
        assertEquals("V", convertToRomansString(5));
        assertEquals("VI", convertToRomansString(6));
        assertEquals("VII", convertToRomansString(7));
        assertEquals("VIII", convertToRomansString(8));
        assertEquals("IX", convertToRomansString(9));
    }

    @Test
    public void testLowerLimit() {
        assertThrows(RuntimeException.class, () -> convertToRomansString(0), "Números menores a 1 no son válidos");
    }

    @Test
    public void testUpperLimit() {
        assertThrows(RuntimeException.class, () -> convertToRomansString(4000),
                "Números mayores a 3999 no son válidos, Decorum no soportado");
    }

    @Test
    public void testConvertTenths() {
        assertEquals("XIV", convertToRomansString(14));
        assertEquals("XXVIII", convertToRomansString(28));
        assertEquals("XXXIII", convertToRomansString(33));
        assertEquals("XLVII", convertToRomansString(47));
        assertEquals("LI", convertToRomansString(51));
        assertEquals("LXII", convertToRomansString(62));
        assertEquals("LXXVI", convertToRomansString(76));
        assertEquals("LXXXIII", convertToRomansString(83));
        assertEquals("XC", convertToRomansString(90));
        assertEquals("XCIX", convertToRomansString(99));
    }

    @Test
    public void testConvertCenths() {
        assertEquals("CXIV", convertToRomansString(114));
        assertEquals("CCXXVIII", convertToRomansString(228));
        assertEquals("CCCXXXIII", convertToRomansString(333));
        assertEquals("CDXLVII", convertToRomansString(447));
        assertEquals("DLI", convertToRomansString(551));
        assertEquals("DCLXII", convertToRomansString(662));
        assertEquals("DCCLXXVI", convertToRomansString(776));
        assertEquals("DCCCLXXXIII", convertToRomansString(883));
        assertEquals("CM", convertToRomansString(900));
        assertEquals("CMXCIX", convertToRomansString(999));
    }

    @Test
    public void testConvertThousanths() {
        assertEquals("MCXIV", convertToRomansString(1114));
        assertEquals("MMCCXXVIII", convertToRomansString(2228));
        assertEquals("MMMCCCXXXIII", convertToRomansString(3333));
        assertEquals("M", convertToRomansString(1000));
    }

    private String convertToRomansString(int aNumberToConvert) {
        if (aNumberToConvert <= 0) {
            throw new RuntimeException("Números menores a 1 no son válidos");
        }
        if (aNumberToConvert > 3999) {
            throw new RuntimeException("Números mayores a 3999 no son válidos, Decorum no soportado");
        }

        StringBuilder romanString = new StringBuilder();
        String reversedDecimal = new StringBuilder(String.valueOf(aNumberToConvert)).reverse().toString();

        if (aNumberToConvert > 999) {
            String[] digits = { "", "M", "MM", "MMM" };
            romanString.append(digits[Character.getNumericValue(reversedDecimal.charAt(3))]);
        }
        if (aNumberToConvert > 99) {
            String[] digits = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
            romanString.append(digits[Character.getNumericValue(reversedDecimal.charAt(2))]);
        }
        if (aNumberToConvert > 9) {
            String[] digits = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
            romanString.append(digits[Character.getNumericValue(reversedDecimal.charAt(1))]);
        }
        String[] digits = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        romanString.append(digits[Character.getNumericValue(reversedDecimal.charAt(0))]);
        return romanString.toString();

    }

}
