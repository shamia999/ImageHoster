package ImageHoster.repository;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {
    @PersistenceUnit(unitName ="imageHoster")
    private EntityManagerFactory emf;

    public Comments submitComment(Comments c)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try
        {
            et.begin();
            em.persist(c);
            et.commit();
        }
        catch (Exception e)
        {
            et.rollback();
        }
return c;
    }
  /*  public List <Comments>showComment(Image i)
    {
     EntityManager em=emf.createEntityManager();
     //EntityTransaction et= em.getTransaction();
      TypedQuery<Comments>t =em.createQuery("SELECT p from Comments p",Comments.class);
     List<Comments>comm = t.getResultList();
     return comm;
    } */

    }
