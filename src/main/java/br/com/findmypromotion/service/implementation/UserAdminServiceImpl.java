package br.com.findmypromotion.service.implementation;

import br.com.findmypromotion.domain.UserAdmin;
import br.com.findmypromotion.repository.UserAdminRepository;
import br.com.findmypromotion.service.Crud;
import groovy.util.logging.Commons;
import org.springframework.beans.factory.annotation.Autowired;
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
            userAdminRepository.save(userAdmin);
        }catch (Exception e){

        }
    }

    public UserAdmin findByEmail(String email){
        try{
            return userAdminRepository.findUserAdminByEmail(email);
        }catch (Exception e){

        }
        return null;
    }

}
