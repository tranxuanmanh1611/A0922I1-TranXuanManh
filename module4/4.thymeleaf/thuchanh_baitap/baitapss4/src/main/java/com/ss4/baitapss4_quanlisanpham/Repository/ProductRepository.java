package com.ss4.baitapss4_quanlisanpham.Repository;

import com.ss4.baitapss4_quanlisanpham.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
    Iterable<Product> findByName(String name);
}
