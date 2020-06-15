package ImageHoster.service;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.List;

@Service
public class CommentService
{
@Autowired
    CommentRepository cr;

    public Comments submitComment(Comments comment)


    {
       return cr.submitComment(comment);

    }
   /* public List showComment(Image i)
    {
       return cr.showComment(i);
    } */
}
