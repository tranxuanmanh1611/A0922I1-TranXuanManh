package com.my_project.validate_signup_form.repository;

import com.my_project.validate_signup_form.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

@RequestMapping
@Transactional
public interface AccountRepository extends CrudRepository<Account,Integer> {
}
