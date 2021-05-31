package com.rom.security.local.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rom.security.common.APIUser;
 
public interface UserRepository extends CrudRepository<APIUser, Long> {
 
    @Query("SELECT u FROM APIUser u WHERE u.username = :username")
    public APIUser findByUsername(@Param("username") String username);
}