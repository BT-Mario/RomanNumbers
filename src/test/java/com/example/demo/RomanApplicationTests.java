package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RomanApplicationTests {
    @Test
    public void testA() {
        assertEquals("I", convertToRomansString(1));
    }

    @Test
    public void testB() {
        var x = assertThrows(RuntimeException.class,
                () -> convertToRomansString(0));
        assertTrue(x.getMessage().equals("Números menores a 1 no son válidos"));
    }

    @Test
    public void testC() {
        assertEquals("II", convertToRomansString(2));
    }

    @Test
    public void testD() {
        assertEquals("III", convertToRomansString(3));
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
