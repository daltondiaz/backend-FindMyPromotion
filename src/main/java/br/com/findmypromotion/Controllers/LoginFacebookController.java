package br.com.findmypromotion.Controllers;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dalton on 12/11/2016.
 */

@Controller
@RequestMapping("/")
public class LoginFacebookController {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    public LoginFacebookController(Facebook facebook, ConnectionRepository connectionRepository){
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    public String getingFacebook(Model model){
        if(connectionRepository.findPrimaryConnection(Facebook.class) == null){
            return "redirect:/connect/facebook";
        }
        model.addAttribute("facebookProfile",facebook.userOperations().getUserProfile());
        PagedList<Post> feed =  facebook.feedOperations().getFeed();
        model.addAttribute("feed",feed);
        return "Hello";
    }



}
