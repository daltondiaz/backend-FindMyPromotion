package br.com.findmypromotion.security;

import br.com.findmypromotion.domain.User;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by Dalton on 14/11/2016.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {


    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getEmail(){
        return this.user.getEmail();
    }

    public long getId(){
        return user.getId();
    }

    public Role getRole(){
        return user.getRole();
    }
}
