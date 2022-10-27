package br.gft.lirics.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.gft.lirics.DTOs.UsuarioDTO;
import br.gft.lirics.domain.Usuario;
import br.gft.lirics.services.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

    private static final String NOME = "Usuario Teste";
    private static final String CPF = "000.002.245-00";
    private static final String EMAIL = "email@test.com";
    private static final String SENHA = "123456";
    private static final String URL = "/api/v1/usuarios";
    
    @MockBean
    UsuarioService service;
    
    @Autowired
    MockMvc mvc;
    
    @Test
    public void testSave() throws Exception{
        BDDMockito.given(service.salvar(Mockito.any(Usuario.class))).willReturn(getMockUser());
        mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    
    public Usuario getMockUser() {
        Usuario u = new Usuario();
        u.setNome(NOME);
        u.setCpf(CPF);
        u.setEmail(EMAIL);
        u.setSenha(SENHA);
        
        return u;        
    }
    
    public String getJsonPayload() throws JsonProcessingException {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome(NOME);
        dto.setCpf(CPF);
        dto.setEmail(EMAIL);
        dto.setSenha(SENHA);
        
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(dto);
    }
    
}
