package com.example.raiffaisen.Repository;

import com.example.raiffaisen.Domain.Entitate;
import com.example.raiffaisen.Repository.ExceptionRepository.RepositoryException;

import java.util.List;

public interface IRepository<T extends Entitate> extends Iterable<T> {
    T findById(int id);
    int returnPosition(int id);
    void add(T entitate) throws RepositoryException;
    void update(T entitate) throws RepositoryException;
    void delete(int id) throws RepositoryException;
    List<T> getAllEntities();
}
