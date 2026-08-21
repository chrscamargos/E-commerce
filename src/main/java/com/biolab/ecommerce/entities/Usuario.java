package com.biolab.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //substitui os getters e setters
@AllArgsConstructor //substitui o contrutor com todos os argumentos
@NoArgsConstructor // substitui o contrutor vazio
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;
    @NotBlank @Email
    @Column(length = 150)
    private String email;
    @Column(length = 20) //Size define o tamanho mínimo e máximo, Lenght muda o tamanho do campo (Ex: de 255 para 20)
    private String telefone;
    @NotBlank @Size(min = 6)
    @Column(length = 150)
    private String senha;
    private String[] roles;

}
