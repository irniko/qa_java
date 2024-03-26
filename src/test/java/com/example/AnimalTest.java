package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    Animal animal;

    @Test
    public void getFamilyTest() {
        animal = new Animal();
        animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }
}