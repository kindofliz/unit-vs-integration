package lv.junittests.unitvsintegration.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

    //Unit Test
    @Test
    void hello() {
        HelloController controller = new HelloController(); //ARRANGE
        String response = controller.hello("World"); //ACT
        assertEquals("Hello, World", response);  //ASSERT
    }
}