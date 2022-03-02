package br.com.digitalbooking.carros.exceptions;

public class UnreportedEssentialFieldException extends RuntimeException {
    public UnreportedEssentialFieldException(String msg) {
        super(msg);
    }
}
