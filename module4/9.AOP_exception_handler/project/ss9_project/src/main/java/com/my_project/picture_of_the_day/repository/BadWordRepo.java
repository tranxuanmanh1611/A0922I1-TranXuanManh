package com.my_project.picture_of_the_day.repository;

import com.my_project.picture_of_the_day.entity.BadWord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BadWordRepo extends CrudRepository<BadWord,Integer> {
}
