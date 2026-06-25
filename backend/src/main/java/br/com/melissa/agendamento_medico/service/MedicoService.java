package br.com.melissa.agendamento_medico.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.melissa.agendamento_medico.entity.Medico;
import br.com.melissa.agendamento_medico.repository.MedicoRepository;

@Service
public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public List<Medico> listarTodos() {
        return repository.findAll(
                Sort.by(Sort.Direction.ASC, "id")
        );
    }

    public Medico salvar(Medico medico) {
        return repository.save(medico);
    }

    public Medico buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Médico não encontrado"));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}