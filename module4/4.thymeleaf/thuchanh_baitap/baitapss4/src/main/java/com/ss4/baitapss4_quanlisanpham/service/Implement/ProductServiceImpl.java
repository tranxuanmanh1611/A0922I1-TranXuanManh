package com.ss4.baitapss4_quanlisanpham.service.Implement;

import com.ss4.baitapss4_quanlisanpham.Repository.ProductRepository;
import com.ss4.baitapss4_quanlisanpham.entity.Product;
import com.ss4.baitapss4_quanlisanpham.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
       Optional<Product> productOptional = productRepository.findById(id);
           return productOptional.get();
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Iterable<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
