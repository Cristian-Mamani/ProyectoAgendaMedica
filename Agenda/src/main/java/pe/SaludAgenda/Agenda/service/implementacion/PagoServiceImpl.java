package pe.SaludAgenda.Agenda.service.implementacion;

import pe.SaludAgenda.Agenda.model.Pago;
import pe.SaludAgenda.Agenda.repository.ICrudGenericoRepository;
import pe.SaludAgenda.Agenda.repository.IPacienteRepository;
import pe.SaludAgenda.Agenda.repository.IPagoRepository;
import pe.SaludAgenda.Agenda.service.IPagoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class PagoServiceImpl extends CrudGenericoServiceImpl<Pago,Long>implements IPagoService {
    private final IPagoRepository pagoRepository;
    @Override
    protected ICrudGenericoRepository<Pago, Long> getRepo() {
        return pagoRepository;
    }
}
