package com.TestProject.Test.documentation;

import springfox.documentation.service.ApiInfo;

import java.util.Collections;

public class ApiDocumentation {
    public ApiInfo apiDescription() {
        return new ApiInfo(
                "Book library API (Test Task)",
                "Createing a simple Library Service API manage to " +
                        "get information of the book(author, title and etc). Technologies " +
                        "Stack - Swagger (To represent API Documentation, as I understood it should be), " +
                        "Rest API with Postrgres to store the Data in local Server. Build tool is Maven. " +
                        "All configuration (connecting to external database and e.t.c) is described in file " +
                        "application.properties. Most important is - I connected to may local database, placed on " +
                        "my own computer. It means if tou want to work with database, you have to change username and " +
                        "password. You alos may to change the database name, but there is ni need. JPA will create DB with " +
                        "title declared in the configuration file (if it is not exist of course). Driver and all " +
                        "required dependencies are already included.",
                "1.0 version",
                "free to use",
                new springfox.documentation.service.Contact(
                        "Polivakha Mikhail",
                        "http://mywayoftheinvestor.ru",
                        "mikhailpolivakha@gmail"),
                "There is no Api license",
                "There is no license url",
                Collections.emptyList());
    }
}
