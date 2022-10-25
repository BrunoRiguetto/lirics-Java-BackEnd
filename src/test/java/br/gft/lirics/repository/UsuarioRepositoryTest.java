package br.gft.lirics.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import br.gft.lirics.domain.Usuario;
import br.gft.lirics.repositories.UsuarioRepository;

@RunWith(SpringRunner.class)
//@ActiveProfiles("test")
@SpringBootTest
//@Sql(scripts = {"/resource/import_usuarios.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class UsuarioRepositoryTest {

	private static final String EMAIL = "email@teste.com";
	
	@Autowired
	UsuarioRepository repository;
	
	@BeforeEach
	public void setUp() {
	}
	@After
	public void tearDown() {
	}
	
	@Test
	public void testCriarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("Test");
		usuario.setEmail("usuario2@gft.com");
		usuario.setSenha("123456");
		usuario.setCpf("000.000.579-00");
		
		Usuario response = repository.save(usuario);
		
		assertNotNull(response);
		repository.delete(response);
	}
	
	@Test
	public void testBuscarPorEmail() {
		Usuario u = new Usuario();
		u.setNome("SetUp User");
		u.setCpf("123.654.987-89");
		u.setSenha("123456");
		u.setEmail(EMAIL);
		repository.save(u);
		
		Optional<Usuario> response = repository.findByEmailEquals(EMAIL);
		
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
		repository.delete(u);
	}
}
