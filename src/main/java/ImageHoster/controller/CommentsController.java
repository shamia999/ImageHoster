package ImageHoster.controller;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.model.UserProfile;
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
import javax.xml.stream.events.Comment;
import java.util.Date;
import java.util.List;

@Controller
public class CommentsController {

    @Autowired
    CommentService cs;
    @Autowired
    ImageService imageService;
    @RequestMapping(value="/image/{imageId}/{imageTitle}/comment",method= RequestMethod.POST)
    public String SubmitComment(@PathVariable("imageId")Integer imageId, @PathVariable("imageTitle")String imageTitle , @RequestParam(name="comment")String Comment1, HttpSession session, Model model)
    {
         User currentUser=(User)session.getAttribute("loggedUser");
         Image I1=imageService.getImage(imageId);
         Comments com=new Comments();
         com.setImage(I1);
         com.setText(Comment1);
         com.setUser(currentUser);
         com.setDate(new Date());
         cs.submitComment(com);
         return "redirect:/images/" +imageId+"/"+imageTitle;
    }

   /* @RequestMapping(value="/image/{imageId}/{imageTitle}/comment",method=RequestMethod.GET)

    public void showComment(@PathVariable("imageId")Integer ImageId,@PathVariable("imageTitle")String title,@RequestParam("comment")String com,Model M)

    {
      Image Image=  imageService.getImage(ImageId);
      List<Comments> Mm=cs.showComment(Image);

          /*User u=new User();
          UserProfile up=new UserProfile();
          u.setProfile(up);
           Comments co=new Comments();
           co.setUser(u);
      M.addAttribute("image",Image);
      M.addAttribute("comment",Mm);
    } */
}

