package br.com.melissa.agendamento_medico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.melissa.agendamento_medico.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}