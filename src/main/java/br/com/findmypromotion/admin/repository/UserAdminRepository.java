package br.com.findmypromotion.admin.repository;

import br.com.findmypromotion.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Dalton on 14/11/2016.
 */
public interface UserAdminRepository extends JpaRepository<User,Long> {

    User findUserAdminByEmail(String email);

}
