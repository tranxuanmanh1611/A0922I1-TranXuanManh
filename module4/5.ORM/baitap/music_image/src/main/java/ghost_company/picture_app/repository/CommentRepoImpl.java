package ghost_company.picture_app.repository;

import ghost_company.picture_app.entity.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class CommentRepoImpl implements CommentRepo{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Comment> findByDate(Date date) {
       return entityManager.createQuery("select m from Comment m where m.commentDate =  :date ").setParameter("date",date).getResultList();
    }

    @Override
    public void addComment(Comment comment) {
        entityManager.persist(comment);
    }
}
