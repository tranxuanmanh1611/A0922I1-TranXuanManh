package com.ss4;

import java.util.List;

public interface Repository<T>{
    List<T> findAll();
    void add(T t);
}
