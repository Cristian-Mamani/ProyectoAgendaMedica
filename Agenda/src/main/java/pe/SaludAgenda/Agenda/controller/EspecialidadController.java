package pe.SaludAgenda.Agenda.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.SaludAgenda.Agenda.model.Especialidad;
import pe.SaludAgenda.Agenda.service.IEspecialidadService;

import java.net.URI;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {
    private final IEspecialidadService especialidadService;



    @GetMapping
    public ResponseEntity<List<Especialidad>> findAll() {
        List<Especialidad> list = especialidadService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> findById(@PathVariable("id") Long
                                                 id) {
        Especialidad obj = especialidadService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Especialidad dto) {
        Especialidad obj = especialidadService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> update(@PathVariable("id") Long
                                               id, @RequestBody
                                       Especialidad dto) {
        dto.setId(id);
        Especialidad obj = especialidadService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        especialidadService.delete(id);
        return ResponseEntity.noContent().build();
    }
}