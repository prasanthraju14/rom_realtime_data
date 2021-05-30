package com.rom.oauth.user;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    //@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "ROMAAAU")
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    
    public User() {
    	super();
    }
    
    public User(long id, String username, String password) {
    	super();
    	this.id = id;
    	this.username = username;
    	this.password = password;
    }
    
    public long getId()
    {
        return id;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(long id) {
		this.id = id;
	}
}
