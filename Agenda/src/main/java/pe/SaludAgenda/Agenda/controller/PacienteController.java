package pe.SaludAgenda.Agenda.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.SaludAgenda.Agenda.model.HistorialClinico;

import pe.SaludAgenda.Agenda.model.Paciente;
import pe.SaludAgenda.Agenda.service.IHistorialClinicoService;
import pe.SaludAgenda.Agenda.service.IPacienteService;

import java.net.URI;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/pacienteController")
public class PacienteController {
    private final IPacienteService pacienteService;



    @GetMapping
    public ResponseEntity<List<Paciente>> findAll() {
        List<Paciente> list = pacienteService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable("id") Long
                                                             id) {
        Paciente obj = pacienteService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Paciente dto) {
        Paciente obj = pacienteService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@PathVariable("id") Long
                                                           id, @RequestBody
                                                   Paciente dto) {
        dto.setId(id);
        Paciente obj = pacienteService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}