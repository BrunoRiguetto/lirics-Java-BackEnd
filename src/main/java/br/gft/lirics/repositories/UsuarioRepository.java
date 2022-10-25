package br.gft.lirics.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gft.lirics.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmailEquals(String email);
}
