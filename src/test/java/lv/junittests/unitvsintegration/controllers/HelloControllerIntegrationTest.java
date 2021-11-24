package lv.junittests.unitvsintegration.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


//Integration Test

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloController.class)
class HelloControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void hello() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Hello, World", result.getResponse().getContentAsString());
    }



    @Test
    public void testHelloWithName() throws Exception {
        mvc.perform(get("/hello?name=Liza"))
                .andExpect(content().string("Hello, Liza"));
    }

}