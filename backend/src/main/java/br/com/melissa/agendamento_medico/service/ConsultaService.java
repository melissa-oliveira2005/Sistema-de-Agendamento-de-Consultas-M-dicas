package br.com.melissa.agendamento_medico.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.melissa.agendamento_medico.entity.Consulta;
import br.com.melissa.agendamento_medico.repository.ConsultaRepository;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public List<Consulta> listarTodos() {
        return repository.findAll();
    }

    public Consulta salvar(Consulta consulta) {
        return repository.save(consulta);
    }

    public Consulta buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}