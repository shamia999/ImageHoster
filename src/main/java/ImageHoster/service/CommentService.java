package ImageHoster.service;

import ImageHoster.model.Comments;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
@Autowired
    CommentRepository cr;
    public void submitComment(Comments comment)
    {
         cr.submitComment(comment);
    }
}
