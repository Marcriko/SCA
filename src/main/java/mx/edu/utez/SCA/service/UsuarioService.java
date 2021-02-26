package mx.edu.utez.SCA.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.utez.SCA.documents.RolDocument;
import mx.edu.utez.SCA.documents.UsuarioDocument;
import mx.edu.utez.SCA.repository.DocenteRepository;
import mx.edu.utez.SCA.repository.RolRepository;
import mx.edu.utez.SCA.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService implements UserDetailsService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RolRepository rolRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private DocenteService docenteService;

	public List<UsuarioDocument> getAll() {
		return usuarioRepository.findAll();
	}

	public boolean save(UsuarioDocument usuario, String autoridad) {
		
		UsuarioDocument us = usuarioRepository.findByUsuario(usuario.getUsuario());
		if (us==null) {

			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			usuario.setEnabled(true);
			RolDocument rol = rolRepository.findByRol(autoridad);
			usuario.setRol(new HashSet<>(Arrays.asList(rol)));
			return usuarioRepository.existsById(usuarioRepository.save(usuario).getId());

		}

		return false;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioDocument usuario = usuarioRepository.findByUsuario(username);
		if (usuario != null) {
			List<GrantedAuthority> authorities = getUserAuthority(usuario.getRol());
			return buildUserForAuthentication(usuario, authorities);
		} else {
			throw new UsernameNotFoundException("Username not found");
		}
	}

	private List<GrantedAuthority> getUserAuthority(Set<RolDocument> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<>();
		userRoles.forEach((role) -> {
			roles.add(new SimpleGrantedAuthority(role.getRol()));
		});
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;
	}

	private UserDetails buildUserForAuthentication(UsuarioDocument usuario, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(usuario.getUsuario(), usuario.getPassword(),
				authorities);
	}

	public boolean delete(String id) {
		usuarioRepository.deleteById(id);
		return !usuarioRepository.existsById(id);
	}

	public boolean save(UsuarioDocument usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return usuarioRepository.existsById((usuarioRepository.save(usuario)).getId());
	}

}
