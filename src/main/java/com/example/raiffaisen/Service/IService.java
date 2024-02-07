package com.example.raiffaisen.Service;

import com.example.raiffaisen.Repository.ExceptionRepository.RepositoryException;

import java.util.List;

public interface IService<T> {
    T findById(int id);
    int returnPosition(int id);
    void add(T entitate) throws RepositoryException;
    void update(T entitate) throws RepositoryException;
    void delete(int id) throws RepositoryException;
    List<T> getAllEntities();
}