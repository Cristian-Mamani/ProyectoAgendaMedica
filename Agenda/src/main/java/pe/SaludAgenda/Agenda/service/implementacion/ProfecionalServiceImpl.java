package pe.SaludAgenda.Agenda.service.implementacion;

import pe.SaludAgenda.Agenda.model.Especialidad;
import pe.SaludAgenda.Agenda.model.Profesional;
import pe.SaludAgenda.Agenda.repository.ICrudGenericoRepository;
import pe.SaludAgenda.Agenda.repository.IProfecionalRepository;
import pe.SaludAgenda.Agenda.service.IEspecialidadService;
import pe.SaludAgenda.Agenda.service.IProfecionalService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class ProfecionalServiceImpl extends CrudGenericoServiceImpl<Profesional,Long>implements IProfecionalService {
    private final IProfecionalRepository profecionalRepository;
    @Override
    protected ICrudGenericoRepository<Profesional, Long> getRepo() {
        return profecionalRepository;
    }
}
