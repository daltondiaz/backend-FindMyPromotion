package br.com.findmypromotion.security;

import br.com.findmypromotion.domain.UserAdmin;
import br.com.findmypromotion.service.implementation.UserAdminServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Dalton on 14/11/2016.
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService{


    private final UserAdminServiceImpl userAdminService;

    public CurrentUserDetailsService(UserAdminServiceImpl userAdminService) {
        this.userAdminService = userAdminService;
    }


    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        UserAdmin userAdmin = userAdminService.findByEmail(email);
        return new CurrentUser(userAdmin);
    }
}
