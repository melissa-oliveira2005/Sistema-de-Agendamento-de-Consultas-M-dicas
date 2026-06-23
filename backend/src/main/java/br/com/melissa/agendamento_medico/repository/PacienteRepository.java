package br.com.melissa.agendamento_medico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.melissa.agendamento_medico.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}