package com.ipnetinstitute.csc394.backend.dao;
import java.util.Optional;

import javax.transaction.Transactional;
import com.ipnetinstitute.csc394.backend.entity.User;

@Transactional
public interface UserEntityRepository extends BaseEntityRepository<User> {


    Optional<User> findByUserName(String username);
    User findByEmail(String email);

    Boolean existsByUserName(String username);
  
    Boolean existsByEmail(String eMail);
   



}
