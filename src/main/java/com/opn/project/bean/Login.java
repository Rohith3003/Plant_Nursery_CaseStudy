package com.opn.project.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer", "FieldHandler" })
public class Login {
	@Id
	@NotEmpty(message = "Please enter email")
	private String email;
	@Size(min = 8, message = "Please enter password with minimum 8 characters")
	@NotEmpty(message = "Please enter password")
	private String password;
	@JsonIgnore
	private boolean isLogin;
}
