package br.com.findmypromotion.security;

import br.com.findmypromotion.admin.domain.UserAdmin;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by Dalton on 14/11/2016.
 */
public class CurrentUser extends User {


    private UserAdmin user;

    public CurrentUser(UserAdmin userAdmin) {
        super(userAdmin.getEmail(), userAdmin.getPassword(), AuthorityUtils.createAuthorityList(userAdmin.getRole().toString()));
        this.user = userAdmin;
    }

    public UserAdmin getUser() {
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
