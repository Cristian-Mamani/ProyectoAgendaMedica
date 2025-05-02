package pe.SaludAgenda.Agenda.service.implementacion;

import pe.SaludAgenda.Agenda.exception.ModelNotFoundException;
import pe.SaludAgenda.Agenda.repository.ICrudGenericoRepository;
import pe.SaludAgenda.Agenda.service.ICrudGenericoService;

import java.util.List;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public abstract class CrudGenericoServiceImpl <T,ID>implements ICrudGenericoService<T,ID> {
    protected abstract ICrudGenericoRepository<T,ID> getRepo();
    @Override
    public T save(T t) {
        return getRepo().save(t);
    }
    @Override
    public T update(ID id, T t) {
        getRepo().findById(id).orElseThrow(() -> new
                ModelNotFoundException("ID NOT FOUND: " + id));
        return getRepo().save(t);
    }
    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }
    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElseThrow(() -> new
                ModelNotFoundException("ID NOT FOUND: " + id));
    }
    @Override
    public void delete(ID id) {
        getRepo().findById(id).orElseThrow(() -> new
                ModelNotFoundException("ID NOT FOUND: " + id));
        getRepo().deleteById(id);
    }
}
