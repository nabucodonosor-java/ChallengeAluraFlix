package com.alura.flix.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alura.flix.dto.RoleDto;
import com.alura.flix.dto.UserDto;
import com.alura.flix.dto.UserInsertDto;
import com.alura.flix.dto.UserUpdateDto;
import com.alura.flix.entities.Role;
import com.alura.flix.entities.User;
import com.alura.flix.repositories.RoleRepository;
import com.alura.flix.repositories.UserRepository;
import com.alura.flix.services.exceptions.DatabaseException;
import com.alura.flix.services.exceptions.ResourceNotFoundException;


@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional(readOnly = true)
	public Page<UserDto> findAllPaged(PageRequest pageRequest) {
		Page<User> list = repository.findAll(pageRequest);
		return UserDto.converter(list);
	}
	
	@Transactional(readOnly = true)
	public UserDto findById(Long id) {
		Optional<User> optional = repository.findById(id);
		User user = optional.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));
		return new UserDto(user);
	}
	
	@Transactional
	public UserDto insert(UserInsertDto dto) {
		User user = new User();
		copyDtoToEntity(dto, user);
		user.setPassword(encoder.encode(dto.getPassword()));
		user = repository.save(user);
		return new UserDto(user);
	}
	
	@Transactional
	public UserDto update(Long id, UserUpdateDto dto) {
		try {
			User user = repository.getOne(id);
			copyDtoToEntity(dto, user);
			user = repository.save(user);
			return new UserDto(user);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Usuário não encontrado! " + id);
		}
	}
	
	public void delete(Long id) {
		try {
			
			repository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Usuário não encontrado! " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de DB");
		}
	}
	
	private void copyDtoToEntity(UserDto dto, User user) {
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		
		user.getRoles().clear();
		
		Role role = new Role(1L, "ROLE_USER");
		
		user.getRoles().add(role);
	}

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		
		User user = repository.findByEmail(userEmail);

		if (user == null) {
			logger.error("Usuário não encontrado!");
			// throw new UsernameNotFoundException("Usuário não encontrado!");
			throw new InvalidGrantException("Usuario Invalido");
		}
		
		return user;
	}
}
