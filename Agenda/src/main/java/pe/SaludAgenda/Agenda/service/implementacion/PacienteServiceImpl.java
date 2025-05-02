package pe.SaludAgenda.Agenda.service.implementacion;

import pe.SaludAgenda.Agenda.model.Paciente;
import pe.SaludAgenda.Agenda.repository.ICrudGenericoRepository;
import pe.SaludAgenda.Agenda.repository.IPacienteRepository;
import pe.SaludAgenda.Agenda.service.IPacienteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class PacienteServiceImpl extends CrudGenericoServiceImpl<Paciente,Long>implements IPacienteService {
    private final IPacienteRepository pacienteRepository;
    @Override
    protected ICrudGenericoRepository<Paciente, Long> getRepo() {
        return pacienteRepository;
    }
}
