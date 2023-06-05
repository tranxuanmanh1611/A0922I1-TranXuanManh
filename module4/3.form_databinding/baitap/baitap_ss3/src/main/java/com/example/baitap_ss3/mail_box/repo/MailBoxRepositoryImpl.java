package com.example.baitap_ss3.mail_box.repo;

import com.example.baitap_ss3.mail_box.entity.MailBox;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MailBoxRepositoryImpl implements MailboxRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<MailBox> findAll() {
     return  entityManager.createQuery("select m from MailBox m").getResultList();
    }

    @Override
    public boolean save(MailBox mailBox) {
        if (entityManager.find(MailBox.class,mailBox.getId())!=null){
            entityManager.merge(mailBox);
        }else {
            entityManager.persist(mailBox);
        }
        return true;
    }

    @Override
    public MailBox findById(int id) {
        return entityManager.find(MailBox.class,id);
    }
}
