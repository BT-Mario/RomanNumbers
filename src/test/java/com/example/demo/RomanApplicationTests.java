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
                ()->convertToRomansString(0));
        assertTrue(x.getMessage().equals("Números menores a 1 no son válidos"));


    }

    private String convertToRomansString(int i) {
        if(i <= 0){
            throw new RuntimeException("Números menores a 1 no son válidos");
        }
        return "I";
    }


}
