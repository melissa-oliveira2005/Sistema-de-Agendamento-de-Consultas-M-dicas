package br.com.melissa.agendamento_medico.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.melissa.agendamento_medico.entity.Paciente;
import br.com.melissa.agendamento_medico.service.PacienteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Paciente> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public Paciente salvar(@RequestBody Paciente paciente) {
        return service.salvar(paciente);
    }

    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
    @GetMapping("/excluir/{id}")
    public String excluirPaciente(@PathVariable Long id) {

        service.excluir(id);

        return "redirect:/pagina-pacientes";
    }
    @PostMapping("/salvar-paciente")
    public String salvarPaciente(
            @Valid Paciente paciente,
            BindingResult result,
            Model model,
            RedirectAttributes attributes) {

        if (result.hasErrors()) {
            model.addAttribute("listaPacientes", service.listarTodos());
            return "pacientes";
        }

        service.salvar(paciente);

        attributes.addFlashAttribute("mensagem", "Paciente salvo com sucesso!");

        return "redirect:/pagina-pacientes";
    }
    @GetMapping("/editar/{id}")
    public String editarPaciente(@PathVariable Long id, Model model) {

        Paciente paciente = service.buscarPorId(id);

        model.addAttribute("paciente", paciente);
        model.addAttribute("listaPacientes", service.listarTodos());

        return "pacientes";
    }
    @GetMapping("/pagina-pacientes")
    public String paginaPacientes(Model model) {

        model.addAttribute("paciente", new Paciente());
        model.addAttribute("listaPacientes", service.listarTodos());

        return "pacientes";
    }

}