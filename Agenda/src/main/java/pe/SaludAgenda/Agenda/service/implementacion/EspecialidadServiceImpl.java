package pe.SaludAgenda.Agenda.service.implementacion;

import pe.SaludAgenda.Agenda.model.Especialidad;
import pe.SaludAgenda.Agenda.repository.ICrudGenericoRepository;
import pe.SaludAgenda.Agenda.repository.IEspecialidadRepository;
import pe.SaludAgenda.Agenda.service.IEspecialidadService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class EspecialidadServiceImpl extends CrudGenericoServiceImpl<Especialidad,Long>implements IEspecialidadService {
    private final IEspecialidadRepository especialidadRepository;
    @Override
    protected ICrudGenericoRepository<Especialidad, Long> getRepo() {
        return especialidadRepository;
    }
}
