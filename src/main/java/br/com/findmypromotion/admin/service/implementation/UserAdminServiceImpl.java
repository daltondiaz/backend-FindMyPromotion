package br.com.findmypromotion.admin.service.implementation;

import br.com.findmypromotion.domain.User;
import br.com.findmypromotion.admin.repository.UserAdminRepository;
import br.com.findmypromotion.admin.service.Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Dalton on 14/11/2016.
 */

@Component
public class UserAdminServiceImpl implements Crud<User> {

    @Autowired
    private UserAdminRepository userAdminRepository;

    //TODO add Log4J

    @Override
    public User getById(long id) {
        try{
            return userAdminRepository.findOne(id);
        }catch (Exception e){

        }
        return null;
    }

    @Override
    public List<User> getList() {
        try{
            return userAdminRepository.findAll();
        }catch (Exception e){

        }
        return null;
    }

    @Override
    public void saverOrUpdate(User userAdmin) {
        try {
            userAdmin.setPassword(new BCryptPasswordEncoder().encode(userAdmin.getPassword()));
            userAdminRepository.save(userAdmin);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public User findByEmail(String email){
        try{
            return userAdminRepository.findUserAdminByEmail(email);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
