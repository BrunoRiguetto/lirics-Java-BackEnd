package br.gft.lirics.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gft.lirics.domain.Usuario;
import br.gft.lirics.repositories.UsuarioRepository;
import br.gft.lirics.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository repository;
	
	@Override
	public Usuario salvar(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	public Optional<Usuario> findByEmail(String email) {
		return repository.findByEmailEquals(email);
	}

}
