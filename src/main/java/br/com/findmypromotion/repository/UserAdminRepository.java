package br.com.findmypromotion.repository;

import br.com.findmypromotion.domain.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Dalton on 14/11/2016.
 */
public interface UserAdminRepository extends JpaRepository<UserAdmin,Long> {

    UserAdmin findUserAdminByEmail(String email);

}
