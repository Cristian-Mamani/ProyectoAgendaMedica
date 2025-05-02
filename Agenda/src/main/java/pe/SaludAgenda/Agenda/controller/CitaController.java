package pe.SaludAgenda.Agenda.controller;

import pe.SaludAgenda.Agenda.service.ICitaService;
import pe.SaludAgenda.Agenda.model.Cita;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/citas")
public class CitaController {
    private final ICitaService citaService;



    @GetMapping
    public ResponseEntity<List<Cita>> findAll() {
        List<Cita> list = citaService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cita> findById(@PathVariable("id") Long
                                                  id) {
        Cita obj = citaService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Cita dto) {
        Cita obj = citaService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cita> update(@PathVariable("id") Long
                                                id, @RequestBody
                                        Cita dto) {
        dto.setId(id);
        Cita obj = citaService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        citaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}