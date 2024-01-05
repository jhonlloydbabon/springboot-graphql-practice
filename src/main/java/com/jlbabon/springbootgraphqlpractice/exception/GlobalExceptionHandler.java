package com.jlbabon.springbootgraphqlpractice.exception;

import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler{

    @GraphQlExceptionHandler
    public GraphQLError movieNotFoundException(MovieNotFoundException ex){
        return GraphQLError.newError()
                .message(ex.getMessage())
                .build();
    }
}
