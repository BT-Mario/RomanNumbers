package com.example.demo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RomanApplicationTests {

    @Test
    public void testA() {
        assertEquals("I", convertToRomansString(1));
        assertEquals("II", convertToRomansString(2));
        assertEquals("III", convertToRomansString(3));
    }

    @Test
    public void testB() {
        var x = assertThrows(RuntimeException.class,
                () -> convertToRomansString(0));
        assertTrue(x.getMessage().equals("Números menores a 1 no son válidos"));
    }

    @Test
    public void testE() {
        assertEquals("IV", convertToRomansString(4));
    }

    @Test
    public void testF() {
        assertEquals("V", convertToRomansString(5));
        assertEquals("VI", convertToRomansString(6));
        assertEquals("VII", convertToRomansString(7));
        assertEquals("VIII", convertToRomansString(8));
    }

    @Test
    public void testG() {
        assertEquals("IX", convertToRomansString(9));
    }

    @Test
    public void testH() {
        assertEquals("X", convertToRomansString(10));
    }

    @Test
    public void testI() {
        assertEquals("XI", convertToRomansString(11));
        assertEquals("XII", convertToRomansString(12));
        assertEquals("XIII", convertToRomansString(13));
    }

    @Test
    public void testK() {
        assertEquals("XV", convertToRomansString(15));
        assertEquals("XVI", convertToRomansString(16));
        assertEquals("XVII", convertToRomansString(17));
        assertEquals("XVIII", convertToRomansString(18));
    }

    @Test
    public void testL() {
        assertEquals("XIX", convertToRomansString(19));
    }

    @Test
    public void testM() {
        assertEquals("XX", convertToRomansString(20));

    }

    private String convertToRomansString(int aNumberToConvert) {
        StringBuilder  romanString = new StringBuilder();

        if (aNumberToConvert <= 0) {
            throw new RuntimeException("Números menores a 1 no son válidos");
        } else if (aNumberToConvert >= 10 && aNumberToConvert <= 19) {
            romanString.append("X");
            aNumberToConvert = aNumberToConvert - 10;
        } else if (aNumberToConvert >= 20) {
            romanString.append("XX");
            aNumberToConvert = aNumberToConvert - 20;
        }
        if (aNumberToConvert <= 3) {
            for (int i = 0; i < aNumberToConvert; i++) {
                romanString.append("I");
            }
        } else if (aNumberToConvert == 4) {
            romanString.append("IV");
        } else if (aNumberToConvert <= 8) {
            romanString.append("V");
            for (int i = 5; i < aNumberToConvert; i++) {
                romanString.append("I");
            }
        } else {
            romanString.append("IX");
        }
        return romanString.toString();

    }
}


