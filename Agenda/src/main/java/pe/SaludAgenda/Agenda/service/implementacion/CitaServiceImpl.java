package pe.SaludAgenda.Agenda.service.implementacion;


import pe.SaludAgenda.Agenda.model.Cita;
import pe.SaludAgenda.Agenda.repository.ICitaRepository;
import pe.SaludAgenda.Agenda.repository.ICrudGenericoRepository;
import pe.SaludAgenda.Agenda.service.ICitaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class CitaServiceImpl extends CrudGenericoServiceImpl<Cita,Long>implements ICitaService {

    private final ICitaRepository citaRepository;
    @Override
    protected ICrudGenericoRepository<Cita, Long> getRepo() {
        return citaRepository;
    }
}
