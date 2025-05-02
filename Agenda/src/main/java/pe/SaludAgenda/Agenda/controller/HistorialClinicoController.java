package pe.SaludAgenda.Agenda.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.SaludAgenda.Agenda.model.HistorialClinico;

import pe.SaludAgenda.Agenda.service.IHistorialClinicoService;

import java.net.URI;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/historialClinico")
public class HistorialClinicoController {
    private final IHistorialClinicoService historialClinicoService;



    @GetMapping
    public ResponseEntity<List<HistorialClinico>> findAll() {
        List<HistorialClinico> list = historialClinicoService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<HistorialClinico> findById(@PathVariable("id") Long
                                                         id) {
        HistorialClinico obj = historialClinicoService.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody HistorialClinico dto) {
        HistorialClinico obj = historialClinicoService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<HistorialClinico> update(@PathVariable("id") Long
                                                       id, @RequestBody
                                               HistorialClinico dto) {
        dto.setId(id);
        HistorialClinico obj = historialClinicoService.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        historialClinicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}