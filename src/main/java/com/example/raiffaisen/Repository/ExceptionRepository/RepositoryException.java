package com.example.raiffaisen.Repository.ExceptionRepository;
public class RepositoryException extends Exception {
    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Throwable e) {
        super(message, e);
    }
}