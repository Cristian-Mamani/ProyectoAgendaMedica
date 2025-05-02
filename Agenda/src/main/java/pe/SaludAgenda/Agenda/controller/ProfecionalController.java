package pe.SaludAgenda.Agenda.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.SaludAgenda.Agenda.model.HistorialClinico;

import pe.SaludAgenda.Agenda.model.Profesional;
import pe.SaludAgenda.Agenda.service.IHistorialClinicoService;
import pe.SaludAgenda.Agenda.service.IProfecionalService;

import java.net.URI;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/profecional")
public class ProfecionalController {
    private final IProfecionalService profecionalService;



    @GetMapping
    public ResponseEntity<List<Profesional>> findAll() {
        List<Profesional> list = profecionalService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Profesional> findById(@PathVariable("id") Long
                                                             id) {
        Profesional obj = profecionalService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Profesional dto) {
        Profesional obj = profecionalService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Profesional> update(@PathVariable("id") Long
                                                           id, @RequestBody
                                                   Profesional dto) {
        dto.setId(id);
        Profesional obj = profecionalService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        profecionalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}