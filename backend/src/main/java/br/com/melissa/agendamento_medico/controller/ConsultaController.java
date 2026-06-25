package br.com.melissa.agendamento_medico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.melissa.agendamento_medico.entity.Consulta;
import br.com.melissa.agendamento_medico.service.ConsultaService;
import br.com.melissa.agendamento_medico.service.MedicoService;
import br.com.melissa.agendamento_medico.service.PacienteService;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;
    private final PacienteService pacienteService;
    private final MedicoService medicoService;

    public ConsultaController(
            ConsultaService consultaService,
            PacienteService pacienteService,
            MedicoService medicoService) {

        this.consultaService = consultaService;
        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
    }

    // Carrega página principal
    @GetMapping("/pagina")
    public String paginaConsultas(Model model) {

        model.addAttribute(
                "consulta",
                new Consulta());

        model.addAttribute(
                "listaConsultas",
                consultaService.listarTodos());

        model.addAttribute(
                "pacientes",
                pacienteService.listarTodos());

        model.addAttribute(
                "medicos",
                medicoService.listarTodos());

        return "consultas";
    }

    // Salvar consulta
    @PostMapping("/salvar")
    public String salvarConsulta(
            Consulta consulta,
            RedirectAttributes attributes) {

        consultaService.salvar(consulta);

        attributes.addFlashAttribute(
                "mensagem",
                "Consulta agendada com sucesso!");

        return "redirect:/pagina-consultas";
    }


    // Editar consulta
    @GetMapping("/editar/{id}")
    public String editarConsulta(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "consulta",
                consultaService.buscarPorId(id));

        model.addAttribute(
                "listaConsultas",
                consultaService.listarTodos());

        model.addAttribute(
                "pacientes",
                pacienteService.listarTodos());

        model.addAttribute(
                "medicos",
                medicoService.listarTodos());

        return "consultas";
    }

    // Excluir consulta
    @GetMapping("/excluir/{id}")
    public String excluirConsulta(
            @PathVariable Long id,
            RedirectAttributes attributes) {

        consultaService.excluir(id);

        attributes.addFlashAttribute(
                "mensagem",
                "Consulta removida com sucesso!");

        return "redirect:/pagina-consultas";
    }

    // API REST (Thunder Client)

    @GetMapping
    @ResponseBody
    public Object listarTodos() {
        return consultaService.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Object buscarPorId(
            @PathVariable Long id) {

        return consultaService.buscarPorId(id);
    }

    @PostMapping
    @ResponseBody
    public Object salvar(
            @RequestBody Consulta consulta) {

        return consultaService.salvar(consulta);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void excluir(
            @PathVariable Long id) {

        consultaService.excluir(id);
    }
}