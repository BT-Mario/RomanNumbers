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
            romanString.append(convertThousanthToRomanString(Character.getNumericValue(reversedDecimal.charAt(3))));
        }
        if (aNumberToConvert > 99) {
            romanString.append(convertCenthToRomanString(Character.getNumericValue(reversedDecimal.charAt(2))));
        }
        if (aNumberToConvert > 9) {
            romanString.append(convertTenthToRomanString(Character.getNumericValue(reversedDecimal.charAt(1))));
        }
        romanString.append(convertUnitToRomanString(Character.getNumericValue(reversedDecimal.charAt(0))));
        return romanString.toString();

    }

    private String convertTenthToRomanString(int aNumberToConvert) {
        switch (aNumberToConvert){
            case 1: return "X";
            case 2: return "XX";
            case 3: return "XXX";
            case 4: return "XL";
            case 5: return "L";
            case 6: return "LX";
            case 7: return "LXX";
            case 8: return "LXXX";
            case 9: return "XC";
        }
        return "";

    }

    private String convertUnitToRomanString(int aNumberToConvert) {
        switch (aNumberToConvert){
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
        }
        return "";

    }

    private String convertCenthToRomanString(int aNumberToConvert) {
        switch (aNumberToConvert){
            case 1: return "C";
            case 2: return "CC";
            case 3: return "CCC";
            case 4: return "CD";
            case 5: return "D";
            case 6: return "DC";
            case 7: return "DCC";
            case 8: return "DCCC";
            case 9: return "CM";
        }
        return "";

    }

    private String convertThousanthToRomanString(int aNumberToConvert) {
        switch (aNumberToConvert){
            case 1: return "M";
            case 2: return "MM";
            case 3: return "MMM";
        }
        return "";

    }
}
