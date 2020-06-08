package ImageHoster.controller;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class CommentsController {

    @Autowired
    CommentService com;
    @Autowired
    ImageService imageService;
    @RequestMapping(value="/image/{imageId}/{imageTitle}/comments",method= RequestMethod.POST)
    public String SubmitComment(@PathVariable("imageId")Integer imageId, @PathVariable("imageTitle")String imageTitle , @RequestParam(name="comments")String Comment1, HttpSession session, Model model)
    {
        User currentUser=(User)session.getAttribute("loggedUser");
        Image I1=imageService.getImage(imageId);
        Comments comment=new Comments();
        comment.setImage(I1);
        comment.setDate(new Date());
        comment.setUser(currentUser);
        comment.setText(Comment1);
        com.submitComment(comment);
        model.addAttribute("comments",I1);
        model.addAttribute("comments",I1);
        return "redirect:images/image";
    }

}
