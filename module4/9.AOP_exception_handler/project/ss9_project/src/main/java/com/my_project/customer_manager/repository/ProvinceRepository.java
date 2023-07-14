package com.my_project.customer_manager.repository;

import com.my_project.customer_manager.entity.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProvinceRepository extends PagingAndSortingRepository<Province,Long> {
}
