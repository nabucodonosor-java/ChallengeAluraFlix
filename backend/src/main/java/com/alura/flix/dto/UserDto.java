package com.alura.flix.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.domain.Page;

import com.alura.flix.entities.User;


public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message = "Campo obrigatório")
	private String name;
	@Email(message = "Digitar email válido!")
	private String email;

	private Set<RoleDto> roles = new HashSet<>();

	public UserDto() {
		super();
	}

	public UserDto(User user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		user.getRoles().forEach(r -> this.roles.add(new RoleDto(r)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<RoleDto> getRoles() {
		return roles;
	}

	public static Page<UserDto> converter(Page<User> list) {
		return list.map(UserDto::new);
	}

}