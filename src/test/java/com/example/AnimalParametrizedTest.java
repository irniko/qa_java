package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalParametrizedTest {

    Animal animal;
    String animalKind;
    List<String> food;

    public AnimalParametrizedTest(String animalKind, List<String> food) {
        this.food = food;
        this.animalKind = animalKind;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Другое", List.of("Неизвестно")}
        };
    }


    @Test
    public void getFoodTest() throws Exception {
        animal = new Animal();
        try {
            assertEquals(food, animal.getFood(animalKind));
        } catch (Exception e) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }
}