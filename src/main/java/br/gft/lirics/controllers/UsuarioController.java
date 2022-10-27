package br.gft.lirics.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gft.lirics.DTOs.UsuarioDTO;
import br.gft.lirics.domain.Usuario;
import br.gft.lirics.response.Response;
import br.gft.lirics.services.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    
    @Autowired
    UsuarioService service;
    
    @PostMapping
    public ResponseEntity<Response<UsuarioDTO>> salvarUsuario(@Valid @RequestBody UsuarioDTO dto, BindingResult result) {
        Response<UsuarioDTO> response = new Response<UsuarioDTO>();
        Usuario usuario = service.salvar(this.convertDtoToEntity(dto));
        response.setData(this.convertEntityToDto(usuario));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    private Usuario convertDtoToEntity(UsuarioDTO dto) {
        Usuario u = new Usuario();
        u.setNome(dto.getNome());
        u.setCpf(dto.getCpf());
        u.setEmail(dto.getEmail());
        u.setSenha(dto.getSenha());
        
        return u;
    }
    
    private UsuarioDTO convertEntityToDto(Usuario u) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome(u.getNome());
        dto.setCpf(u.getCpf());
        dto.setEmail(u.getEmail());
        dto.setSenha(u.getSenha());
        
        return dto;
    }

}
