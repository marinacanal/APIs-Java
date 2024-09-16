package com.example.apis.validation;

public class PaginaNaoEncontrada extends RuntimeException {

    public PaginaNaoEncontrada() {
        super();
    }

    public PaginaNaoEncontrada(String message) {
        super(message);
    }

    public PaginaNaoEncontrada(String message, Throwable cause) {
        super(message, cause);
    }
}