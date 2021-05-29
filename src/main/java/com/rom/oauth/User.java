

package com.rom.oauth;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "ROMOAUTH")
    @Enumerated(EnumType.STRING)
    private Provider provider;
    private String username;
    private boolean enabled;
 
    public User() {
    	super();
    }
    
    public User(Provider provider, String username, boolean enabled) {
    	this.provider = provider;
    	this.username = username;
    	this.enabled = enabled;
    }
    
   
    public Provider getProvider() {
        return provider;
    }
 
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

	public String getUserName() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
