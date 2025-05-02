package pe.SaludAgenda.Agenda.service.implementacion;

import pe.SaludAgenda.Agenda.model.Usuario;
import pe.SaludAgenda.Agenda.repository.ICrudGenericoRepository;
import pe.SaludAgenda.Agenda.repository.IUsuarioRepositoy;
import pe.SaludAgenda.Agenda.service.IUsuarioService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends CrudGenericoServiceImpl<Usuario,Long>implements IUsuarioService {
    private final IUsuarioRepositoy usuarioRepositoy;
    @Override
    protected ICrudGenericoRepository<Usuario, Long> getRepo() {
        return usuarioRepositoy;
    }
}
