package com.codegym.blog.repository.impl;

import com.codegym.blog.entity.Blog;
import com.codegym.blog.repository.BlogRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepositoryImpl implements BlogRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Blog> findAll() {
        String query = "select b from Blog b";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Blog findById(int id) {
        return entityManager.find(Blog.class,id);
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId()==null){
            entityManager.persist(blog);
        }
        entityManager.merge(blog);
    }

    @Override
    public void update(Blog blog) {

    }

    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}
