package com.rom.oauth.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
 
public interface UserRepository extends CrudRepository<MyUser, Long> {
 
    @Query("SELECT u FROM MyUser u WHERE u.username = :username")
    public MyUser findByUsername(@Param("username") String username);
}