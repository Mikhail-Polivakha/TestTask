package com.TestProject.Test.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookResourseController.class)
public class BookResourseControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        BookResourseController bookResourseController;

        @BeforeAll
        void testControllerExistense() throws Exception {
            assertThat(bookResourseController).isNotNull();
        }

        @Test
        @Disabled
        @DisplayName("Getting whole books from repository")
        void testGettingWholeBooks() throws Exception {
                RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Library/");
                MvcResult mvcResult = mockMvc.perform(requestBuilder).
                        andExpect(status().is2xxSuccessful()).
                        andReturn();
                assertThat(mvcResult).isNotNull();
        }

        @Test
        @Disabled
        @DisplayName("Getting certain book from repository")
        void testGettingCertainBook() throws Exception {
                RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/Library/1");
                MvcResult mvcResult = mockMvc.perform(requestBuilder)
                        .andExpect(status().is2xxSuccessful())
                        .andReturn();
                assertThat(mvcResult).isNotNull();
        }

        @Test
        @DisplayName("Test posting a new Book into reposiotry")
        void testingPostMethod() throws Exception {
                RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/");
                mockMvc.perform(requestBuilder)
                        .andExpect(status().is2xxSuccessful());
        }

        @Test
        @Disabled
        @DisplayName("Test deleting the book from repository")
        void testDeleteBook() throws Exception {
                RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/");
                mockMvc.perform(requestBuilder)
                        .andExpect(status().is2xxSuccessful());
        }

        @Test
        @Disabled
        @DisplayName("Testing Put mapping allows to Update the book")
        void testUpdatingBook() throws Exception {
                RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/");
                mockMvc.perform(requestBuilder)
                        .andExpect(status().is2xxSuccessful());
        }
}
