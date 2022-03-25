package com.cs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Data
public class Login 
{
	@Id
	private String email;
	private String password;
	@JsonIgnore
	private boolean isLogin;
}
