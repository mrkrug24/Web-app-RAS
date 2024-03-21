package com.prosphere.ras.services;
import java.util.List;
import com.prosphere.ras.DAO.CommonOthersDAO;

public abstract class CommonOthersService<T, DAO extends CommonOthersDAO<T>> {
    protected DAO dao;

    public CommonOthersService(DAO dao) {
        this.dao = dao;
    }

    public List<T> findAll() {
        return dao.findAll();
    }

    // public void save(T obj) {
    //     dao.save(obj);
    // }

    public void update(T obj) {
        dao.update(obj);
    }   

    public void delete(T obj) {
        dao.delete(obj);
    }
}