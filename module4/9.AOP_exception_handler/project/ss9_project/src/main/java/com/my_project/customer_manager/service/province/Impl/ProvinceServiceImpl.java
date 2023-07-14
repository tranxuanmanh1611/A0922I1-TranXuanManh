package com.my_project.customer_manager.service.province.Impl;

import com.my_project.customer_manager.entity.Province;
import com.my_project.customer_manager.repository.ProvinceRepository;
import com.my_project.customer_manager.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;
    @Override
    public Iterable<Province> findAll() {
       return provinceRepository.findAll();

    }

    @Override
    public Province findById(Long id) {
        Optional<Province> provinceOptional = provinceRepository.findById(id);
        return provinceOptional.orElse(null);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Province province) {
        provinceRepository.delete(province);
    }
}
