package inpecable.inpecableSpring.modelo.service;

import inpecable.inpecableSpring.modelo.Servicio;
import inpecable.inpecableSpring.modelo.dao.IServicioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioServiceImpl implements IServicioService{
    @Autowired
    private IServicioDao servicioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> findAll() {
        return (List<Servicio>) servicioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Servicio findById(Long id) {
        return servicioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Servicio save(Servicio servicio) {
        return servicioDao.save(servicio);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        servicioDao.deleteById(id);
    }
}
