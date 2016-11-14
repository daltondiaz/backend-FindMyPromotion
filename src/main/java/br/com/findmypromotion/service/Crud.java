package br.com.findmypromotion.service;

import java.util.List;

/**
 * Created by Dalton on 14/11/2016.
 */
public interface Crud<T> {

    T getById(long id);
    List<T> getList();
    void saverOrUpdate(T t);
}
