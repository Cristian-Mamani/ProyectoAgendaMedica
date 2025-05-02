package pe.SaludAgenda.Agenda.service.implementacion;

import pe.SaludAgenda.Agenda.model.HistorialClinico;
import pe.SaludAgenda.Agenda.repository.ICrudGenericoRepository;
import pe.SaludAgenda.Agenda.repository.IHistorialClinicoRepository;
import pe.SaludAgenda.Agenda.service.IHistorialClinicoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class HistorialClinicoSeriviceImpl extends CrudGenericoServiceImpl<HistorialClinico,Long>implements IHistorialClinicoService {
    private final IHistorialClinicoRepository historialClinicoRepository;
    @Override
    protected ICrudGenericoRepository<HistorialClinico, Long> getRepo() {
        return historialClinicoRepository;
    }
}
