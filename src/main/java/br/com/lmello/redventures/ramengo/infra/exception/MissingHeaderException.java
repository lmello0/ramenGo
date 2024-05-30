package br.com.lmello.redventures.ramengo.infra.exception;

public class MissingHeaderException extends RuntimeException {
    public MissingHeaderException(String s) {
        super(s + " header missing");
    }
}
