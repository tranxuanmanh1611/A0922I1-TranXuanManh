package com.my_project.validate_signup_form.account_service;

import com.my_project.validate_signup_form.entity.Account;
import com.my_project.validate_signup_form.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository accountRepository;
    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
