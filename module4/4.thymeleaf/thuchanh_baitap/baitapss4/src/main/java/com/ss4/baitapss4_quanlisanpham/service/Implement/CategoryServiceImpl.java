package com.ss4.baitapss4_quanlisanpham.service.Implement;

import com.ss4.baitapss4_quanlisanpham.Repository.CategoryRepository;
import com.ss4.baitapss4_quanlisanpham.entity.Category;
import com.ss4.baitapss4_quanlisanpham.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }
}
