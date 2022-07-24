import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {

    @Test
    void nullParameterShouldThrowIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class,()->new Hippodrome(null));
    }

    @Test
    public
    void nullParameterShouldThrowIllegalArgumentExceptionWithMessageHorsesCannotBeNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        String expectedMessage = "Horses cannot be null.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    void blinkListParametersShouldThrowIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class,()->new Hippodrome(new ArrayList<>()));
    }

    @Test
    public
    void blinkListParametersShouldThrowIllegalArgumentExceptionWithMessageHorsesCannotBeEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
        String expectedMessage = "Horses cannot be empty.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getHorses() {
    }

    @Test
    void move() {
    }

    @Test
    void getWinner() {
    }
}