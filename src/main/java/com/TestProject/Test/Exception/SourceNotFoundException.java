package com.TestProject.Test.Exception;

import io.swagger.annotations.ApiModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@ApiModel(description = "It is the model of the exception we may be have to hadle. If we searching for the book " +
        "in repository wich is not exist (it is simple example), BookService will throw the exception")
public class SourceNotFoundException extends Exception{

    public SourceNotFoundException(String message) {
        super(message);
    }
}
