package com.example.raiffaisen.Service;

import com.example.raiffaisen.Domain.Entitate;
import com.example.raiffaisen.Domain.Investor;
import com.example.raiffaisen.Repository.ExceptionRepository.RepositoryException;
import com.example.raiffaisen.Repository.IRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service<T extends Entitate> implements IService<T> {
    private IRepository<T> repoGeneric;

    public Service(IRepository<T> Repository) {
        this.repoGeneric = Repository;
    }

    @Override
    public T findById(int id) {
        return repoGeneric.findById(id);
    }

    @Override
    public int returnPosition(int id) {
        return repoGeneric.returnPosition(id);
    }

    @Override
    public void add(T entitate) throws RepositoryException {
        repoGeneric.add(entitate);
    }

    @Override
    public void update(T entitate) throws RepositoryException {
        repoGeneric.update(entitate);
    }

    @Override
    public void delete(int id) throws RepositoryException {
        repoGeneric.delete(id);
    }

    @Override
    public List<T> getAllEntities() {
        return repoGeneric.getAllEntities();
    }
}


