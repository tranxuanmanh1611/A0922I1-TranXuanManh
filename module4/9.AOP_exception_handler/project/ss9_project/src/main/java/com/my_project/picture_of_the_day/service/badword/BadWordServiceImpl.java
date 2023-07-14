package com.my_project.picture_of_the_day.service.badword;

import com.my_project.picture_of_the_day.entity.BadWord;
import com.my_project.picture_of_the_day.repository.BadWordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BadWordServiceImpl implements BadWordService{
    @Autowired
    BadWordRepo badWordRepo;

    @Override
    public Iterable<BadWord> findAll() {
        return badWordRepo.findAll();
    }
}
