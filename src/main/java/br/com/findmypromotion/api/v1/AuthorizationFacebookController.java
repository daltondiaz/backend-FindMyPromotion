package br.com.findmypromotion.api.v1;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Dalton on 15/11/2016.
 */
@RestController("/api/v1")
public class AuthorizationFacebookController {

    private Facebook facebook;

    public AuthorizationFacebookController(Facebook facebook){
        this.facebook = facebook;
    }

    //https://graph.facebook.com/me?fields=id&access_token=%40accesstoken&__mref=message_bubble

    @RequestMapping(method= RequestMethod.GET, value = "/{accessToken}")
    public boolean validUserFacebook(@PathVariable String accessToken){

        Facebook facebook = new FacebookTemplate(accessToken);

        if(facebook.isAuthorized()){
            return true;
        }
        return false;
    }
}
