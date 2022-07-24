import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {

    @Test
    public void nullParameterShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    @Test
    public void nullParameterShouldThrowIllegalArgumentExceptionWithMessageHorsesCannotBeNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        String expectedMessage = "Horses cannot be null.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void blinkListParametersShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
    }

    @Test
    public void blinkListParametersShouldThrowIllegalArgumentExceptionWithMessageHorsesCannotBeEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
        String expectedMessage = "Horses cannot be empty.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }


    @Test
    void checkGetListOfHorses() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("Horse" + i, 10, 10));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses, hippodrome.getHorses());

    }

    @Test
    void checkMoveForAllHorses() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(mock(Horse.class));
        }

        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();

        for (Horse horse :
                horses) {
            verify(horse).move();

        }

    }

    @Test
    void checkFoGetHorseWithMaxDistance() {
        Horse horse1 = new Horse("Horse1",1,1);
        Horse horse2 = new Horse("Horse2",1,2);
        Horse horse3 = new Horse("Horse3",1,3);
        Horse horse4 = new Horse("Horse4",1,4);
        Horse horse5 = new Horse("Horse5",1,5);

        Hippodrome hippodrome=new Hippodrome(List.of(horse1,horse2,horse3,horse4,horse5));
        Horse actualHorse = hippodrome.getWinner();

        assertSame(horse5,actualHorse);
    }
}