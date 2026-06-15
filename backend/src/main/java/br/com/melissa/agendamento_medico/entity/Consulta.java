package br.com.melissa.agendamento_medico.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

    private Long id;
    private LocalDateTime dataHora;
    public enum StatusConsulta {
        AGENDADA,
        REALIZADA,
        CANCELADA
    };

    private Paciente paciente;
    private Medico medico;
    
}