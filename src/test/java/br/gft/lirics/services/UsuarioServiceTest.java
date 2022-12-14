package br.gft.lirics.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.gft.lirics.domain.Usuario;
import br.gft.lirics.repositories.UsuarioRepository;
import br.gft.lirics.services.impl.UsuarioServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioServiceTest {

	@MockBean
	UsuarioRepository repository;
	
	@Autowired
	UsuarioServiceImpl service;
	
	@BeforeEach
	public void setUp() {
		BDDMockito.given(repository.findByEmailEquals(Mockito.anyString())).willReturn(Optional.of(new Usuario()));
	}
	
	@Test
	public void testFindByEmail() {
		Optional<Usuario> usuario = service.findByEmail("email@test.com");
		
		assertTrue(usuario.isPresent());
	}
}
