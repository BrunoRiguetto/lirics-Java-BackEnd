package br.gft.lirics.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.gft.lirics.DTOs.UsuarioDTO;
import br.gft.lirics.domain.Usuario;
import br.gft.lirics.services.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

    private static final Long ID = 1L;
    private static final String NOME = "Usuario Teste";
    private static final String CPF = "000.002.245-00";
    private static final String EMAIL = "email2@gmail.com";
    private static final String SENHA = "123456";
    private static final String URL = "/api/v1/usuarios";
    
    @MockBean
    UsuarioService service;
    
    @Autowired
    MockMvc mvc;
    
    @Test
    public void testSalvar() throws Exception{
        
        when(service.salvar(Mockito.any(Usuario.class))).thenReturn(getMockUser());
        
        mvc.perform(post(URL)
                .content(getJsonPayload(ID, NOME, CPF, EMAIL, SENHA))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.data.id").value(ID))
            .andExpect(jsonPath("$.data.nome").value(NOME))
            .andExpect(jsonPath("$.data.cpf").value(CPF))
            .andExpect(jsonPath("$.data.email").value(EMAIL))
            .andExpect(jsonPath("$.data.senha").value(SENHA));
    }
    
    @Test
    public void testSalvarUsuarioInvalido() throws JsonProcessingException, Exception {
        mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload(ID, NOME, CPF, "email", SENHA))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors[0]").value("Email inválido."));
    }
    
    public Usuario getMockUser() {
        Usuario u = new Usuario();
        u.setId(ID);
        u.setNome(NOME);
        u.setEmail(EMAIL);
        u.setCpf(CPF);
        u.setSenha(SENHA);
        
        return u;        
    }
    
    public String getJsonPayload(Long id, String nome, String cpf, String email, String senha) throws JsonProcessingException {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(id);
        dto.setNome(nome);
        dto.setCpf(cpf);
        dto.setEmail(email);
        dto.setSenha(senha);
        
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(dto);
    }
    
}
