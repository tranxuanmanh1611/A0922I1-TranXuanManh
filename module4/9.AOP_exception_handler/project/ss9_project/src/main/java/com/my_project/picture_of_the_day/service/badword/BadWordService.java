package com.my_project.picture_of_the_day.service.badword;

import com.my_project.picture_of_the_day.entity.BadWord;

public interface BadWordService {
    Iterable<BadWord> findAll();
}
