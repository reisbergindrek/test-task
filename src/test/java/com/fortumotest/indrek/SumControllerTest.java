package com.fortumotest.indrek;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SumControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
    	super.setUp();
    }

    @Test
    public void addNumbers() throws Exception {

        int a = 100;
        int b = 200;

        String expected = Integer.toString(a + b);

        mvc.perform(MockMvcRequestBuilders.post("/").content(Integer.toString(a))).andReturn();
		mvc.perform(MockMvcRequestBuilders.post("/").content(Integer.toString(b))).andReturn();

		MvcResult mvcResultEnd = mvc.perform(MockMvcRequestBuilders.post("/").content(SumController.escape)).andReturn();

        String content = mvcResultEnd.getResponse().getContentAsString();
        assertEquals(content, expected);
    }
}