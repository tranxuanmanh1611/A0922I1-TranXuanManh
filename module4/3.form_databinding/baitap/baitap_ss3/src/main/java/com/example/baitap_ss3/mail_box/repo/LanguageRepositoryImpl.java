package com.example.baitap_ss3.mail_box.repo;

import com.example.baitap_ss3.mail_box.entity.Language;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LanguageRepositoryImpl implements LanguageRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Language> findAll() {
        return entityManager.createQuery("select l from Language l").getResultList();
    }

    @Override
    public boolean save(Language language) {
        return false;
    }

    @Override
    public Language findById(int id) {
        return entityManager.find(Language.class,id);
    }
}
