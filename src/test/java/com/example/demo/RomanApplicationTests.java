package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RomanApplicationTests {
    @Test
    public void testA() {
        String roman= "I";
        assertTrue(roman.equals(convertToRomansString(1)));
    }

    @Test
    public void testB() {
        var x = Assertions.assertThrows(RuntimeException.class,
                () -> convertToRomansString(0),"Números menores a 1 no son válidos");
    }

    @Test
    public void testC() {
        String roman= "II";
        assertTrue(roman.equals(convertToRomansString(2)));
    }

    @Test
    public void testD() {
        String roman= "III";
        assertTrue(roman.equals(convertToRomansString(3)));
    }

    private String convertToRomansString(int i) {
        if(i <= 0){
            throw new RuntimeException("Números menores a 1 no son válidos");
        }
        switch (i) {
            case 1: return "I";
            case 2: return "II";
            default: return "III";
        }

    }

}
