package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    Feline feline;
    @Spy
    Feline felineSpy;

    @Test
    public void eatMeatTest() throws Exception {
        feline = new Feline();
        assertEquals(feline.getFood("Хищник"), feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        feline = new Feline();
        System.out.println(feline.getFamily());
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensWithParameterTest() {
        feline = new Feline();
        assertEquals(1, feline.getKittens());
    }
}