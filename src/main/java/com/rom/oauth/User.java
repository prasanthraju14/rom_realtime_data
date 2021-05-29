package com.rom.oauth;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
 
@Entity
@Table(name = "users")
public class User {

    @Enumerated(EnumType.STRING)
    private Provider provider;
 
    public Provider getProvider() {
        return provider;
    }
 
    public void setProvider(Provider provider) {
        this.provider = provider;
    }
     

}