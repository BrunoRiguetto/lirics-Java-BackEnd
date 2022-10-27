package br.gft.lirics.DTOs;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UsuarioDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long usuarioId;
    
    @NotBlank
    private String nome;
    
    @NotBlank
    private String cpf;
    
    @Email
    @NotBlank
    private String email;
    
    @NotBlank
    @Length(min = 6, message = "A senha deve conter no mínimo 6 caracteres.")
    private String senha;
}
