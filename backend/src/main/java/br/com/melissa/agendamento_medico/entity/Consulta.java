package br.com.melissa.agendamento_medico.entity;

import java.time.LocalDateTime;

public class Consulta {

    private Long id;
    private LocalDateTime dataHora;
    private String status;

    private Paciente paciente;
    private Medico medico;

    public Consulta() {
    }

    public Consulta(Long id,
                    LocalDateTime dataHora,
                    String status,
                    Paciente paciente,
                    Medico medico) {
        this.id = id;
        this.dataHora = dataHora;
        this.status = status;
        this.paciente = paciente;
        this.medico = medico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}