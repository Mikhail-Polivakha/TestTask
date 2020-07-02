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
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @Autowired
    AuthorController authorController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    @DisplayName("Testing the injection of controller")
    void controllerTest() {
        assertThat(authorController).isNotNull();
    }

    @Test
    @DisplayName("Test getting all the authors")
    void testGettingAllAuthors() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/authors/");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertThat(result).isNotNull();
    }

    @Test
    @Disabled
    @DisplayName("Test of getting certain author by id")
    void testGettingCertainAuthorByID() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/authors/id?id=1");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        assertThat(mvcResult).isNotNull();
    }

    @Test
    @Disabled
    @DisplayName("Test of getting certain author by id")
    void testGettingCertainAuthorByFirstName() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/authors/firstname?firstname=Robert");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        assertThat(mvcResult).isNotNull();
    }

    @Test
    @Disabled
    @DisplayName("Test post the author to external server")
    void testPostAuthorRequest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/");
        mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
    }

    @Test
    @Disabled
    @DisplayName("Test updating information about the author")
    void testPutAuthorRequest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/");
        mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
    }

    @Test
    @Disabled
    @DisplayName("Test deleting the Author from repository")
    void testDeleteAuthorFromRepository() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/");
        mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful());
    }
}
