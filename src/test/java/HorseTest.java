import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    private Horse horse;

    @BeforeEach
    void init() {
        horse = new Horse("Horse", 100, 1000);
    }

    @AfterEach
    void destroy() {
    }

    //constructor 1
    @Test
    public void nullFirstParameterShouldThrowIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 0));
    }

    //constructor 2
    @Test
    public void nulFirstParameterShouldThrowIllegalArgumentExceptionWithMessageNameCanntBeNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 0));
        String expectedMessage = "Name cannot be null.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }

    //constructor 3
    @ParameterizedTest
    @CsvSource({
            ",0",
            "   ,0"
    })
    public void blankFirstParameterThrowIllegalArgumentException(String name,double speed) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(name,speed));
    }


    //constructor 4
    @Test
    public void blankFirstParameterThrowIllegalArgumentExceptionWithMessageNameCannotBeBlank() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse("    ",0));
        String expectedMessage = "Name cannot be blank.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage,actualMessage);
    }

    //constructor 5
    @Test
    public void negativeSecondParameterShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("Horse", -1));

    }

    //constructor 6
    @Test
    public void negativeSecondParameterShouldThrowIllegalArgumentExceptionWithMessageSpedCannotBeNegative(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse("Horse", -1));
        String expectedMessage = "Speed cannot be negative.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    //constructor 7
    @Test
    public void negativeThirdParameterShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("Horse", 0,-1));

    }

    //constructor 8
    @Test
    public void negativeThirdParameterShouldThrowIllegalArgumentExceptionWithMessageSpedCannotBeNegative(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Horse("Horse", 0,-1));
        String expectedMessage = "Distance cannot be negative.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    void getNameWhichWasInParameter() {
        String actualName = horse.getName();
        assertEquals("Horse", actualName);

    }

    @Test
    void getSpeedWhichWasInParameter() {
        double actualSpeed = horse.getSpeed();
        assertEquals(100, actualSpeed);
    }

    @Test
    void getDistanceWhichWasInParameter() {
        double actualDistance= horse.getDistance();
        assertEquals(1000,actualDistance);
    }

    @Test
    void getNullDistanceIfConstructorDoesnotContainsThirdParameter() {
        double actualDistance= (new Horse("Horse",100)).getDistance();
        assertEquals(0,actualDistance);
    }

    @Test
    void move() {
    }


}