package br.com.melissa.agendamento_medico.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

    private Long id;
    private String nome;
    private String crm;
    private String especialidade;
    private String email;

}