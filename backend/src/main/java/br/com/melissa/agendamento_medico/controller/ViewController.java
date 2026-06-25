package br.com.melissa.agendamento_medico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.melissa.agendamento_medico.entity.Consulta;
import br.com.melissa.agendamento_medico.entity.Medico;
import br.com.melissa.agendamento_medico.entity.Paciente;
import br.com.melissa.agendamento_medico.service.ConsultaService;
import br.com.melissa.agendamento_medico.service.MedicoService;
import br.com.melissa.agendamento_medico.service.PacienteService;

@Controller
public class ViewController {

    private final PacienteService pacienteService;
    private final MedicoService medicoService;
    private final ConsultaService consultaService;

    public ViewController(
            PacienteService pacienteService,
            MedicoService medicoService,
            ConsultaService consultaService) {

        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
        this.consultaService = consultaService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/pagina-pacientes")
    public String pacientes(Model model) {

        model.addAttribute("paciente", new Paciente());
        model.addAttribute(
            "listaPacientes",
            pacienteService.listarTodos()
        );

        return "pacientes";
    }

    @GetMapping("/pagina-consultas")
    public String consultas(Model model) {

        model.addAttribute("consulta", new Consulta());
        model.addAttribute("pacientes", pacienteService.listarTodos());
        model.addAttribute("medicos", medicoService.listarTodos());

        model.addAttribute("listaConsultas", consultaService.listarTodos());

        return "consultas";
    }


    @GetMapping("/pagina-medicos")
    public String medicos(Model model) {

        model.addAttribute("medico", new Medico());

        model.addAttribute(
                "listaMedicos",
                medicoService.listarTodos());

        return "medicos";
    }

}