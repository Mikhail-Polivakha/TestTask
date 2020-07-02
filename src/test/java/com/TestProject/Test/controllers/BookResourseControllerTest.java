package com.TestProject.Test.controllers;

import com.TestProject.Test.controllers.BookResourseController;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class BookResourseControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        BookResourseController bookResourseController;

        @Test
        void testController() throws Exception {
            assertThat(bookResourseController).isNotNull();
        }

        @Test
        void test() throws Exception {
                this.mockMvc
                        .perform(get("/"))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().string(containsString("")));
        }

}
