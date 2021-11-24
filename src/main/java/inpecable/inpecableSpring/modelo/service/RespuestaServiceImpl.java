package inpecable.inpecableSpring.modelo.service;


import inpecable.inpecableSpring.modelo.Respuesta;
import inpecable.inpecableSpring.modelo.dao.IRespuestaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RespuestaServiceImpl implements IRespuestaService{
    @Autowired
    private IRespuestaDao respuestaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Respuesta> findAll() {
        return (List<Respuesta>) respuestaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Respuesta findById(Long id) {
        return respuestaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Respuesta save(Respuesta respuesta) {
        return respuestaDao.save(respuesta);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        respuestaDao.deleteById(id);
    }

}
