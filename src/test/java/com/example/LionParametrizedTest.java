package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    Feline feline = Mockito.mock(Feline.class);
    Lion lion;
    private final String sex;
    private final boolean hasMane;
    private final String exeptionText;

    public LionParametrizedTest(String sex, boolean hasMane, String exeptionText) {
        this.sex = sex;
        this.hasMane = hasMane;
        this.exeptionText = exeptionText;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Самец", true, ""},
                {"Самка", false, ""},
                {"другое", false, "Используйте допустимые значения пола животного - самец или самка"}
        };
    }

    @Test
    public void doesHaveManeTest() {
        try {
            lion = new Lion(sex, feline);
            assertEquals(hasMane, lion.doesHaveMane());

        } catch (Exception e) {
            assertEquals(exeptionText, e.getMessage());
        }

    }
}