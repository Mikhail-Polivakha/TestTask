package com.TestProject.Test;

import com.TestProject.Test.Controllers.BookResourseController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestRequests {

    BookResourseController bookResourseController;
    TestRequests testRequests;

    @BeforeEach
    void creatingInstanseOfTestedClass() {
        bookResourseController = new BookResourseController();
    }

    @Nested
    class GetTest {

        @Test
        void testingGetAllBooks() {
           // assertEquals(libraryResourseController.getAllbooks());
        }
    }
}
