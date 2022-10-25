package br.gft.lirics.services;

import java.util.Optional;

import br.gft.lirics.domain.Usuario;

public interface UsuarioService {

	Usuario salvar(Usuario usuario);
	
	Optional<Usuario> findByEmail(String email);
	
}
