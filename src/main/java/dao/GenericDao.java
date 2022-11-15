/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import paging.Pageable;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<ID extends Serializable, T> {
    List<T> findAll();
    T update(T entity);
    void save(T entity);
    void deleteOne(T entity);
    T findById(ID id);
    Integer delete(List<ID> ids);
    public List<T> findAllPaging(Pageable pageable);
    Object[] findByProperty(String property, Object value,String sortExpression, String sortDirection);

}
