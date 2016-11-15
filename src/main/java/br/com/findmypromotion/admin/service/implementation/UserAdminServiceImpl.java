package br.com.findmypromotion.admin.service.implementation;

import br.com.findmypromotion.admin.domain.UserAdmin;
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
public class UserAdminServiceImpl implements Crud<UserAdmin> {

    @Autowired
    private UserAdminRepository userAdminRepository;

    //TODO add Log4J

    @Override
    public UserAdmin getById(long id) {
        try{
            return userAdminRepository.findOne(id);
        }catch (Exception e){

        }
        return null;
    }

    @Override
    public List<UserAdmin> getList() {
        try{
            return userAdminRepository.findAll();
        }catch (Exception e){

        }
        return null;
    }

    @Override
    public void saverOrUpdate(UserAdmin userAdmin) {
        try {
            userAdmin.setPassword(new BCryptPasswordEncoder().encode(userAdmin.getPassword()));
            userAdminRepository.save(userAdmin);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public UserAdmin findByEmail(String email){
        try{
            return userAdminRepository.findUserAdminByEmail(email);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}