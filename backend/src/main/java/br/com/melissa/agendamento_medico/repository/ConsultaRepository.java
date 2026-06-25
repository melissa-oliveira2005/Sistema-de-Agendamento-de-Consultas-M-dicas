package br.com.melissa.agendamento_medico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.melissa.agendamento_medico.entity.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

}