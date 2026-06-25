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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.melissa.agendamento_medico.entity.Medico;
import br.com.melissa.agendamento_medico.service.MedicoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }


    @GetMapping
    @ResponseBody
    public List<Medico> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    @ResponseBody
    public Medico salvar(@RequestBody Medico medico) {
        return service.salvar(medico);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Medico buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @GetMapping("/excluir/{id}")
    public String excluirMedico(@PathVariable Long id) {

        service.excluir(id);

        return "redirect:/pagina-medicos";
    }

    @PostMapping("/salvar-medico")
    public String salvarMedico(
            @Valid Medico medico,
            BindingResult result,
            Model model,
            RedirectAttributes attributes) {

        if (result.hasErrors()) {

            model.addAttribute(
                    "listaMedicos",
                    service.listarTodos());

            return "medicos";
        }

        service.salvar(medico);

        attributes.addFlashAttribute(
                "mensagem",
                "Médico salvo com sucesso!");

        return "redirect:/pagina-medicos";
    }

    @GetMapping("/editar/{id}")
    public String editarMedico(
            @PathVariable Long id,
            Model model) {

        Medico medico = service.buscarPorId(id);

        model.addAttribute("medico", medico);

        model.addAttribute(
                "listaMedicos",
                service.listarTodos());

        return "medicos";
    }
    
}